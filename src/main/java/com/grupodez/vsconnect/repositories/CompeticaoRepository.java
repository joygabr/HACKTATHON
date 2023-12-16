package com.grupodez.vsconnect.repositories;

import com.grupodez.vsconnect.models.CompeticaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompeticaoRepository extends JpaRepository<CompeticaoModel, UUID> {
}
