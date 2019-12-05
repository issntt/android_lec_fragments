package com.example.fragment.data;

public class DataService {
    public static final DataItem[] dataItems = {
            new DataItem("Item 0", "Details about Item: 0"),
            new DataItem("Item 1", "Details about Item: 1"),
            new DataItem("Item 2", "Details about Item: 2"),
            new DataItem("Item 3", "Details about Item: 3"),
            new DataItem("Item 4", "Details about Item: 4"),
            new DataItem("Item 5", "Details about Item: 5")
    };

    public static DataItem getItem(int itemId) {
        return dataItems[itemId];
    }
}
