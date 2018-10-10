package abstract_class_custom_linkedlist;

public interface NodeList {

    ListItem getRoot();

    boolean addItem(ListItem newItem);

    boolean removeItem(ListItem newItem);

    void traverse(ListItem root);
}
