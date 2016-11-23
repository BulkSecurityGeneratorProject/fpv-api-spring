package com.dstsystems.fpv.service;

import com.dstsystems.fpv.domain.Changeset;
import com.dstsystems.fpv.repository.ChangesetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Changeset.
 */
@Service
@Transactional
public class ChangesetService {

    private final Logger log = LoggerFactory.getLogger(ChangesetService.class);
    
    @Inject
    private ChangesetRepository changesetRepository;

    /**
     * Save a changeset.
     *
     * @param changeset the entity to save
     * @return the persisted entity
     */
    public Changeset save(Changeset changeset) {
        log.debug("Request to save Changeset : {}", changeset);
        Changeset result = changesetRepository.save(changeset);
        return result;
    }

    /**
     *  Get all the changesets.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Changeset> findAll(Pageable pageable) {
        log.debug("Request to get all Changesets");
        Page<Changeset> result = changesetRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one changeset by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public Changeset findOne(Long id) {
        log.debug("Request to get Changeset : {}", id);
        Changeset changeset = changesetRepository.findOne(id);
        return changeset;
    }

    /**
     *  Delete the  changeset by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Changeset : {}", id);
        changesetRepository.delete(id);
    }
}