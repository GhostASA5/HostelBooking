package com.project.HostelBooking.services;

import com.project.HostelBooking.exceptions.HotelNotFoundException;
import com.project.HostelBooking.mappers.HotelMapper;
import com.project.HostelBooking.model.Hotel;
import com.project.HostelBooking.repositories.HotelRepository;
import com.project.HostelBooking.utils.BeanUtils;
import com.project.HostelBooking.web.dto.hotel.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelListResponse getAllHotels(Integer page, Integer size) {
        return hotelMapper.hotelListToResponseList(hotelRepository.findAll(PageRequest.of(page, size)).getContent());
    }

    public HotelResponse getHotelById(Long id) {
        return hotelMapper.hotelToResponse(
                hotelRepository.findById(id).orElseThrow(() ->
                        new HotelNotFoundException(MessageFormat.format("Отель с id {0} не найден.", id))));
    }

    public HotelResponse createHotel(HotelCreateRequest request){
        Hotel newHotel = hotelMapper.hotelCreateToHotel(request);
        return hotelMapper.hotelToResponse(hotelRepository.save(newHotel));
    }

    public HotelUpdateResponse updateHotel(Long id, HotelUpdateRequest request){
        Hotel updateHotel = hotelMapper.hotelUpdateToHotel(id, request);
        Optional<Hotel> excitedHotel = hotelRepository.findById(id);

        if (excitedHotel.isPresent()){
            BeanUtils.copyNonNullProperties(updateHotel, excitedHotel.get());
            return hotelMapper.hotelToUpdateResponse(hotelRepository.save(excitedHotel.get()));
        }
        throw new HotelNotFoundException(MessageFormat.format("Отель с id {0} не найден.", id));
    }

    public void deleteHotel(Long id) {
        Optional<Hotel> excitedHotel = hotelRepository.findById(id);

        if (excitedHotel.isPresent()){
            hotelRepository.deleteById(id);
        }
        throw new HotelNotFoundException(MessageFormat.format("Отель с id {0} не найден.", id));
    }
}
