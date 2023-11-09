package com.dailynewsjoy.repository;

import com.dailynewsjoy.entity.News;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Serializable> {
}
