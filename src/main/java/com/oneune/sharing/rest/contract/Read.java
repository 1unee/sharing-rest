package com.oneune.sharing.rest.contract;


import com.oneune.sharing.rest.store.dto.core.AbstractDto;

import java.util.List;

public interface Read<D extends AbstractDto> {
    D getById(Long dtoId);
    List<D> getAll();
}
