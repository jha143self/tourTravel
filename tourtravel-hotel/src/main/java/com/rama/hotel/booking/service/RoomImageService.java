package com.rama.hotel.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rama.hotel.booking.model.RoomImages;
import com.rama.hotel.booking.repository.RoomImageRepository;

@Service("roomImagesService")
@Transactional
public class RoomImageService {

    @Autowired
    private RoomImageRepository dao;

    public RoomImages findById(int id) {
        Optional<RoomImages> tmp = dao.findById(id);
        return tmp.orElse(null);
    }

    public List<RoomImages> findByRoomId(int id) {
        return dao.findByRoomId(id);
    }

    public List<RoomImages> findAll() {
        return dao.findAll();
    }

    public void save( RoomImages image) {
        dao.save(image);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void deleteByRoomId(int id) {
        List<RoomImages> roomImages = findByRoomId(id);

        for (RoomImages roomImage : roomImages) deleteById(roomImage.getId());
    }

    public void update( RoomImages image) {
        Optional<RoomImages> entity = dao.findById(image.getId());
        if (entity.isPresent()) {
            image.setId(entity.get().getId());
            dao.save(image);
        }
    }
}
