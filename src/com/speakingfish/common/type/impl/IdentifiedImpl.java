package com.speakingfish.common.type.impl;

import com.speakingfish.common.Equals;
import com.speakingfish.common.Compares;
import com.speakingfish.common.type.Identified;

import static com.speakingfish.common.Hashes.*;

public class IdentifiedImpl<ID, T> implements Identified<ID, T>, Comparable<Identified<ID, ?>> {

    protected final ID _id;

    public IdentifiedImpl(ID id) {
        super();
        assert null != id;
        _id = id;
    }

    @Override public ID id() { return _id; }

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
        
        return Equals.equals(this.id(), ((Identified<ID, ?>) obj).id());
    }

    @Override public int compareTo(Identified<ID, ?> o) {
        return Compares.compareObjects(id(), o.id());
    }
}
