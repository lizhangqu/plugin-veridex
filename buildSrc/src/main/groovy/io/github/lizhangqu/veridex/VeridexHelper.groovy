package io.github.lizhangqu.veridex

import org.apache.commons.io.FilenameUtils
import org.gradle.api.Action
import org.gradle.api.Project
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.process.ExecSpec
import org.gradle.util.GFileUtils


/**
 * @author lizhangqu
 */
class VeridexHelper {
    Project project

    VeridexHelper(Project project) {
        this.project = project
    }

    public void execute(File filePath) {
        if (filePath == null || !filePath.exists()) {
            project.logger.error("filePath == null or not exist")
            return
        }
        File veridexFile = getVeridexFile()
        File apacheStubsFile = getApacheStubsFile()
        File systemStubsFile = getSystemStubsFile()
        File hiddenApiFlagFile = getHiddenApiFlagFile()
        if (veridexFile == null || apacheStubsFile == null || systemStubsFile == null || hiddenApiFlagFile == null) {
            project.logger.error("file == null")
            return
        }
        if (!veridexFile.exists() || !apacheStubsFile.exists() || !systemStubsFile.exists() || !hiddenApiFlagFile.exists()) {
            project.logger.error("file not exist")
            return
        }

        project.logger.error("veridex current file: ${filePath}")
        project.exec(new Action<ExecSpec>() {
            @Override
            void execute(ExecSpec execSpec) {
                execSpec.executable veridexFile
                execSpec.args("--core-stubs=${apacheStubsFile.getAbsolutePath()}:${systemStubsFile.getAbsolutePath()}")
                execSpec.args("--api-flags=${hiddenApiFlagFile.getAbsolutePath()}")
                execSpec.args("--dex-file=${filePath.getAbsolutePath()}")
            }
        })
    }


    public File getVeridexFile() {
        String filePath = null
        if (Os.isFamily(Os.FAMILY_MAC)) {
            filePath = "veridex/veridex-mac"
        } else if (Os.isFamily(Os.FAMILY_UNIX)) {
            filePath = "veridex/veridex-linux"
        } else if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            return null
        }
        return getFileFromResource(filePath)
    }

    public File getApacheStubsFile() {
        return getFileFromResource("veridex/org.apache.http.legacy-stubs.zip")
    }

    public File getSystemStubsFile() {
        return getFileFromResource("veridex/system-stubs.zip")
    }


    public File getHiddenApiFlagFile() {
        return getFileFromResource("veridex/hiddenapi-flags.csv")
    }

    private File getFileFromResource(String resourcePath) {
        if (resourcePath == null) {
            return null
        }
        try {
            URL url = this.getClass().getClassLoader().getResource(resourcePath)
            if (url != null) {
                File file = new File(url.getFile())
                if (file.isFile() && file.exists()) {
                    file.setExecutable(true)
                    return file
                }
                //取jar包中的文件
                URL jarUrl = this.getClass().getProtectionDomain().getCodeSource().getLocation()
                if (jarUrl != null) {
                    File jarFile = new File(jarUrl.getFile())
                    File jarFolder = new File(jarFile.getParentFile(),
                            FilenameUtils.getBaseName(jarFile.getName()))
                    GFileUtils.mkdirs(jarFolder)
                    file = new File(jarFolder, resourcePath)
                    GFileUtils.mkdirs(file.getParentFile())
                    if (file.isFile() && file.exists()) {
                        file.setExecutable(true)
                        return file
                    }
                    //否则解压
                    new FileOutputStream(file).withStream {
                        def inputStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath)
                        it.write(inputStream.getBytes())
                    }
                    file.setExecutable(true)
                    return file
                }
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
        return null
    }


}