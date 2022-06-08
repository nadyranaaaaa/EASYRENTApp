package com.application.easyrentapp;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Iterator;

class FirebaseArray implements ChildEventListener {
    private Query mQuery;
    private FirebaseArray.OnChangedListener mListener;
    private ArrayList<DataSnapshot> mSnapshots;

    public FirebaseArray(Query ref) {
        this.mQuery = ref;
        this.mSnapshots = new ArrayList();
        this.mQuery.addChildEventListener(this);
    }

    public void cleanup() {
        this.mQuery.removeEventListener(this);
    }

    public int getCount() {
        return this.mSnapshots.size();
    }

    public DataSnapshot getItem(int index) {
        return (DataSnapshot)this.mSnapshots.get(index);
    }

    private int getIndexForKey(String key) {
        int index = 0;

        for(Iterator var3 = this.mSnapshots.iterator(); var3.hasNext(); ++index) {
            DataSnapshot snapshot = (DataSnapshot)var3.next();
            if (snapshot.getKey().equals(key)) {
                return index;
            }
        }

        throw new IllegalArgumentException("Key not found");
    }

    public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
        int index = 0;
        if (previousChildKey != null) {
            index = this.getIndexForKey(previousChildKey) + 1;
        }

        this.mSnapshots.add(index, snapshot);
        this.notifyChangedListeners(FirebaseArray.OnChangedListener.EventType.ADDED, index);
    }

    public void onChildChanged(DataSnapshot snapshot, String previousChildKey) {
        int index = this.getIndexForKey(snapshot.getKey());
        this.mSnapshots.set(index, snapshot);
        this.notifyChangedListeners(FirebaseArray.OnChangedListener.EventType.CHANGED, index);
    }

    public void onChildRemoved(DataSnapshot snapshot) {
        int index = this.getIndexForKey(snapshot.getKey());
        this.mSnapshots.remove(index);
        this.notifyChangedListeners(FirebaseArray.OnChangedListener.EventType.REMOVED, index);
    }

    public void onChildMoved(DataSnapshot snapshot, String previousChildKey) {
        int oldIndex = this.getIndexForKey(snapshot.getKey());
        this.mSnapshots.remove(oldIndex);
        int newIndex = previousChildKey == null ? 0 : this.getIndexForKey(previousChildKey) + 1;
        this.mSnapshots.add(newIndex, snapshot);
        this.notifyChangedListeners(FirebaseArray.OnChangedListener.EventType.MOVED, newIndex, oldIndex);
    }

    public void onCancelled(DatabaseError databaseError) {
        this.notifyCancelledListeners(databaseError);
    }

    public void setOnChangedListener(FirebaseArray.OnChangedListener listener) {
        this.mListener = listener;
    }

    protected void notifyChangedListeners(FirebaseArray.OnChangedListener.EventType type, int index) {
        this.notifyChangedListeners(type, index, -1);
    }

    protected void notifyChangedListeners(FirebaseArray.OnChangedListener.EventType type, int index, int oldIndex) {
        if (this.mListener != null) {
            this.mListener.onChanged(type, index, oldIndex);
        }

    }

    protected void notifyCancelledListeners(DatabaseError databaseError) {
        if (this.mListener != null) {
            this.mListener.onCancelled(databaseError);
        }

    }

    public interface OnChangedListener {
        void onChanged(FirebaseArray.OnChangedListener.EventType var1, int var2, int var3);

        void onCancelled(DatabaseError var1);

        public static enum EventType {
            ADDED,
            CHANGED,
            REMOVED,
            MOVED;

            private EventType() {
            }
        }
    }
}
