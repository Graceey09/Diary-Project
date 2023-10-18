package com.olofofo.services;

import com.olofofo.data.models.Entry;

public interface EntryServices {
    Entry addEntry(String username, String title, String body);

    Entry findEntry(String username, String title);
}
