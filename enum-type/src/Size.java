public enum Size {

    SMALL("S"), MDEIUM("M"), LARGE("L");
    private String description;

    Size(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
