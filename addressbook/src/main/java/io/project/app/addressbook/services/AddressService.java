package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.domain.Address;
import io.project.app.addressbook.dto.AccountDTO;
import io.project.app.addressbook.dto.AddressDTO;
import io.project.app.addressbook.repositories.AccountRepository;
import io.project.app.addressbook.repositories.AddressRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> createAddress(AddressDTO addressDTO) {
        log.info("AccountService: creating account");
        Address convertedData = convertEntityToDto(addressDTO);

        Optional<Address> findAddressByPhoneNumber = addressRepository.findByPhoneNumber(convertedData.getPhoneNumber());

        if (findAddressByPhoneNumber.isPresent()) {
            log.error("address with that phone number already exists");
            return Optional.empty();
        }

        final Address savedAddress = addressRepository.save(convertedData);

        return Optional.ofNullable(savedAddress);
    }
    
    public static AddressDTO convertEntityToDto(Address address) {
        AddressDTO addressDTOResponse = new AddressDTO();
        try {
            BeanUtils.copyProperties(address, addressDTOResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating AddressDTO response from Address", e);
        }
        return addressDTOResponse;
    }

    public static Address convertEntityToDto(AddressDTO addressDTO) {
        Address addressResponse = new Address();
        try {
            BeanUtils.copyProperties(addressDTO, addressResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Address from AddressDTO", e);
        }
        return addressResponse;
    }
}
