package com.speakingfish.common.type;

import com.speakingfish.common.function.Getter;

public interface OriginatedGetter<ORIGIN, T> extends Originated<ORIGIN>, Getter<T>{

}
