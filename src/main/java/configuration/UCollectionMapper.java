package configuration;

import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UCollectionMapper extends ModelMapper {

    public <S, D> List<D> mapAsList(@NonNull Iterable<S> sources, Class<D> dClass) {
        List<D> list = new ArrayList<>();
        sources.forEach(s -> list.add(super.map(s, dClass)));
        return list;
    }

    public <S, D> Set<D> mapAsSet(@NonNull Iterable<S> sources, Class<D> dClass) {
        Set<D> set = new HashSet<>();
        sources.forEach(s -> set.add(super.map(s, dClass)));
        return set;
    }
}
