package com.dstsystems.fpv.service;

import com.dstsystems.fpv.domain.Floor;
import com.dstsystems.fpv.repository.FloorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Service Implementation for managing Floor.
 */
@Service
@Transactional
public class FloorService {

    private final Logger log = LoggerFactory.getLogger(FloorService.class);

    @Inject
    private FloorRepository floorRepository;

    /**
     * Save a floor.
     *
     * @param floor the entity to save
     * @return the persisted entity
     */
    public Floor save(Floor floor) {
        log.debug("Request to save Floor : {}", floor);
        Floor result = floorRepository.save(floor);
        return result;
    }

    /**
     *  Get all the floors.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Floor> findAll(Pageable pageable,Long buildingId) {
        log.debug("Request to get all Floors");

        if (buildingId!=null){
            floorRepository.findByBuilding(pageable,buildingId);
        }
        Page<Floor> result = floorRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one floor by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Floor findOne(Long id) {
        log.debug("Request to get Floor : {}", id);
        Floor floor = floorRepository.findOne(id);
        return floor;
    }

    /**
     *  Delete the  floor by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Floor : {}", id);
        floorRepository.delete(id);
    }
}
