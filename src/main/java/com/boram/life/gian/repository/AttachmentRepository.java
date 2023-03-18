package com.boram.life.gian.repository;

import com.boram.life.domain.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachments, Integer> {
}
