package com.springmvc.cardekho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.cardekho.pojo.AdminPOJO;
import com.springmvc.cardekho.pojo.CarPOJO;
import com.springmvc.cardekho.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService service;

	// Home page Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Add page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Add car Controller
	@PostMapping("/add")
	public String addCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam String name,
			@RequestParam String brand, @RequestParam String fuel, @RequestParam long price, ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.addCar(name, brand, fuel, price);

			// Success
			if (car != null) {
				map.addAttribute("msg", "Car added successfully..!");
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("msg", cars);
				return "Add";
			}
			// Failure
			map.addAttribute("msg", "Car not added..!");
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", cars);
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Search page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Search car Controller
	@PostMapping("/search")
	public String searchCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.searchCar(id);
			// Success
			if (car != null) {
				map.addAttribute("car", car);
				map.addAttribute("msg", "Car found..!");
				return "Search";
			}
			// Failure
			map.addAttribute("msg", "Car not found..!");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Remove page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			// Success
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Remove";
			}
			map.addAttribute("msg", "No cars present..!");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Remove car Controller
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.removeCar(id);
			List<CarPOJO> cars = service.findAllCars();

			// Success
			if (car != null) {
				map.addAttribute("msg", "Car removed successfully..!");
				map.addAttribute("cars", cars);
				return "Remove";
			}
			// Failure
			map.addAttribute("msg", "Car does not exist..!");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Update page Controller
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Update car Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.searchCar(id);
			// Success
			if (car != null) {
				map.addAttribute("car", car);
				return "Update";
			}
			// Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car not found..!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Update car Controller
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			@RequestParam String name, @RequestParam String brand, @RequestParam String fuel, @RequestParam long price,
			ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.updateCar(id, name, brand, fuel, price);
			// Success
			if (car != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("msg", "Car updated successfully..!");
				map.addAttribute("cars", cars);
				return "Update";
			}
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "Car not updated..!");
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
}
