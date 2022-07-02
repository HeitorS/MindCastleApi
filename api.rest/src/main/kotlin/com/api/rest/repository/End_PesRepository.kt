package com.api.rest.repository

import com.api.rest.model.EndPes
import org.springframework.data.jpa.repository.JpaRepository

interface End_PesRepository: JpaRepository<EndPes, Long> {
}