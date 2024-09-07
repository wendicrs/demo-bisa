package com.example.demobancobisa.repository;

import com.example.demobancobisa.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}