package akadamia.utils;

import org.springframework.stereotype.Component;

public interface Mapper<F, T> {

  T map(F from);

  F revers(T to);
}
