package io.github.lizhangqu.veridex


/**
 * @author lizhangqu
 */
class VeridexResult {
    int number
    boolean linking
    boolean reflection
    String type
    String callee
    Set<String> caller

    VeridexResult() {
        this.caller = new HashSet<>()
    }

    int getNumber() {
        return number
    }

    void setNumber(int number) {
        this.number = number
    }

    String getType() {
        return type
    }

    void setType(String type) {
        this.type = type
    }

    String getCallee() {
        return callee
    }

    void setCallee(String callee) {
        this.callee = callee
    }

    Set<String> getCaller() {
        return caller
    }

    void addCaller(String caller) {
        this.caller.add(caller)
    }

    boolean isLinking() {
        return linking
    }

    void setLinking(boolean linking) {
        this.linking = linking
    }

    boolean isReflection() {
        return reflection
    }

    void setReflection(boolean reflection) {
        this.reflection = reflection
    }


    @Override
    public String toString() {
        return "VeridexResult{" +
                "number=" + number +
                ", linking=" + linking +
                ", reflection=" + reflection +
                ", type='" + type + '\'' +
                ", callee='" + callee + '\'' +
                ", caller=" + caller +
                '}';
    }
}