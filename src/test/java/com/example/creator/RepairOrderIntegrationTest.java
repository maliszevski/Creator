package com.example.creator;

import com.example.creator.model.Customer;
import com.example.creator.model.RepairOrder;
import com.example.creator.model.Vehicle;
import com.example.creator.repository.CustomerRepository;
import com.example.creator.repository.RepairOrderRepository;
import com.example.creator.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class RepairOrderIntegrationTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RepairOrderRepository repairOrderRepository;


    @Test
    public void testCreateRepairOrder() {
        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Kowalski");
        customer.setPhoneNumber("123456789");
        customer.setEmail("jan@kowalski.pl");
        customer.setAddress("Zielona Góra");
        customer.setPostcode("65-001");
        customer.setNipNumber(1234567890);
        customer = customerRepository.save(customer);

        Vehicle vehicle = new Vehicle();
        vehicle.setCustomer(customer); // relacja ManyToOne
        vehicle.setBrand("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setYearOfProduction(2020);
        vehicle.setRegistrationNumber("FZ12345");
        vehicle.setEngineCapacity(1600);
        vehicle.setMileage(15000);
        vehicle.setVinNumber("JT1234567890123456");
        vehicle = vehicleRepository.save(vehicle);

        RepairOrder order = new RepairOrder();
        order.setVehicle(vehicle);
        order.setDescription("Wymiana oleju i filtrów");
        order.setCity("Zielona Góra");
        order.setOrderDate(LocalDate.now());
        order = repairOrderRepository.save(order);

        Optional<RepairOrder> savedOrder = repairOrderRepository.findById(order.getId());
        assertThat(savedOrder).isPresent();
        assertThat(savedOrder.get().getVehicle().getBrand()).isEqualTo("Toyota");
        assertThat(savedOrder.get().getVehicle().getCustomer().getName()).isEqualTo("Jan");
        assertThat(savedOrder.get().getDescription()).isEqualTo("Wymiana oleju i filtrów");
    }


}
