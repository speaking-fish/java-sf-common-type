package com.speakingfish.common.type.impl;

import com.speakingfish.common.type.Identified;

import static com.speakingfish.common.Hashes.*;
import static com.speakingfish.common.Equals.*;
import static com.speakingfish.common.Compares.*;

public class IdentifiedImpl<ID, T> implements Identified<ID, T>, Comparable<Identified<ID, ?>> {

    protected final ID _id;

    public IdentifiedImpl(ID id) {
        super();
        assert null != id;
        _id = id;
    }

    public ID id() { return _id; }

    @Override public String toString() { return id().toString(); }

    @Override public int hashCode() {
        return hash(_id);
    }

    @SuppressWarnings("unchecked")
    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof IdentifiedImpl))
            return false;
        
        return equalsOf(this.id(), ((Identified<ID, ?>) obj).id());
    }

    public int compareTo(Identified<ID, ?> o) {
        return compareObjects(id(), o.id());
    }
}
