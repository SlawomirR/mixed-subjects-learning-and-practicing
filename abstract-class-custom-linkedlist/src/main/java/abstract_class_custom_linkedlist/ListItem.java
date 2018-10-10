package abstract_class_custom_linkedlist;

abstract class ListItem {

    ListItem rightLink = null;
    ListItem leftLink = null;

    private Object value;

    ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();

    abstract ListItem setNext(ListItem item);

    abstract ListItem previous();

    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    Object getValue() {
        return value;
    }

    void setValue(Object value) {
        this.value = value;
    }
}
