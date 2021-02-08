package net.yasri.microservice.repositories;

import net.yasri.microservice.domain.Bread;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BreadRepository extends PagingAndSortingRepository<Bread, UUID> {
}
