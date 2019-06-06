package io.github.lizhangqu.veridex


/**
 * @author lizhangqu
 */
class VeridexList extends ArrayList<VeridexResult> {
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder()
        int number = 0
        int linked = 0
        int reflection = 0
        Map<String, Integer> count = new TreeMap<>()
        this.each {
            number++
            if (it.reflection) {
                reflection++
            }
            if (it.linking) {
                linked++
            }
            stringBuilder.append("#${it.number}: ${it.reflection ? "Reflection" : (it.linking ? "Linking" : "Unknown")} ${it.type} ${it.callee} use(s):\n")
            it.caller?.each {
                stringBuilder.append("       ${it}\n")
            }
            if (it.caller?.size() > 0) {
                stringBuilder.append("\n")
            }
            if (!count.containsKey(it.type)) {
                count.put(it.type, 1)
            } else {
                count.put(it.type, count.get(it.type) + 1)
            }
        }
        stringBuilder.append("${number} hidden API(s) used: ${linked} linked against, ${reflection} through reflection\n")
        count?.each {
            stringBuilder.append("       ${it.value} in ${it.key}\n")
        }
        return stringBuilder.toString()
    }
}