package com.example.deliveryservicemvc.repository;

import com.example.deliveryservicemvc.document.DeliveryDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<DeliveryDoc, String> {
}
