package com.oneune.sharing.rest.contract;

import com.oneune.sharing.rest.store.dto.core.AbstractDto;

/**
 * Common CRUD contract
 * @param <D> dto
 */
public interface CRUDed<D extends AbstractDto> extends Read<D> {
    D post(D dto);
    D put(Long dtoId, D dto);
    D deleteById(Long dtoId);
}
