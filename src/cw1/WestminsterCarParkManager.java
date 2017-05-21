package cw1;

import java.util.Scanner;

public class WestminsterCarParkManager extends Vehicle implements CarParkManager {

	
	private static final int charge = 3;
	
	private VehicleOb[] vehicle = { new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(),
			new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(),
			new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb(),
			new VehicleOb(), new VehicleOb(), new VehicleOb(), new VehicleOb() };

	public void menu() {

		Scanner sc = new Scanner(System.in);

		/*
		 * Displaying the main menu user must select one of the following
		 * options
		 */
		System.out.println("----------------------------");
		System.out.println(" ------- MAIN MENU -------  ");
		System.out.println("----------------------------");
		System.out.println(" ");
		System.out.println("Please choose one of the following options:");
		System.out.println(" ");
		System.out.println("*Press A to add a vehicle to the system");
		System.out.println("*Press R to remove a vehicle from the system");
		System.out.println("*Press S to search a vehicle stored in the system");
		System.out.println("*Press V to list and view vehicles stored in the system according to chronological order");
		System.out.println(" ");
		System.out.println("Press X to exit");

		/*
		 * char for getting the users option by a character this will only take
		 * first charactor of a any word user can give full name of the option
		 * or just a word User have to give a option other wise it will not
		 * continue.
		 */

		char option;
		option = sc.next().toUpperCase().charAt(0);

		// Switch case for getting the relevant data to make the option
		switch (option) {
		// if user enters A, execute addVehicle method.
		case 'A':
			addVehicle();
			break;

		// if user enters V, execute viewVehicle method.
		case 'V':
			viewVehicle();
			break;

		// if user enters S, execute searchVehicle method.
		case 'S':
			searchType();
			break;

		// if user enter R execute removeVehicle method.
		case 'R':
			removeVehicle();
			break;

		// if user enter X,Display a message and exits the system.
		case 'X':
			System.out.println("System exits");

			break;
		// default is for , if user input anything other than requested inputs
		default:
			System.err.println(" ");
			System.err.println("Invalid Response");
			System.out.println(" ");
			menu();
		}

	}

	// addVehicle is to select the vehicle that need to add to the car park
	public void addVehicle() {
		Scanner sc = new Scanner(System.in);

		System.out.println(" ");
		System.out.println(" You have selected to add a vehicle (press x to exit)");
		System.out.println(" ");

		// select the type of the vehicle to park
		System.out.println("Select the type of the Vehicle that need to add to the carpark: ");
		System.out.println(" ");
		System.out.println("   V : add a Van");
		System.out.println("   C : add a car.");
		System.out.println("   B : add a bike.");

		System.out.println("Press Z to return to the main menu");

		char option;
		option = sc.next().toUpperCase().charAt(0);

		// Switch case for getting the relevant data to make the option
		switch (option) {
		// if user enters V, execute addVan method.
		case 'V':
			addVan();
			break;

		// if user enters C, execute addCar method.
		case 'C':
			addCar();
			break;

		// if user enters B, execute addBike method.
		case 'B':
			addBike();
			break;

		// if user enter X execute System.exit
		case 'X':
			System.out.println(" ");
			System.out.println("System exits");
			System.exit(0);
			break;

		// if user enter z,Display a message. and go back to privious point
		case 'Z':
			System.out.println("Going back Successful!!!");

			break;
		// default is for , if user input anything other than requested inputs
		default:
			System.err.println(" ");
			System.err.println("Invalid input, going back to the last saved point");
			System.out.println(" ");
			menu();
		}

	}

	// addCar method is for user to add Cars
	public void addCar() {

		Scanner sc = new Scanner(System.in);

		// display add car input menu
		System.out.println(" ");
		System.out.println(" You have selected to add a Car (press x to exit)");
		System.out.println(" ");
		System.out.println("Press A to proceed or Z to return to Vehicle Addition Menu");

		// option for selecting the users response to proceed or go back
		String option = sc.next();

		if (option.equalsIgnoreCase("A")) {

			System.out.println("Please enter the vehicle ID plate Number");
			// getting the id plate number
			String idPlate = sc.next();

			// Checking the id plate number
			if (idPlate.equalsIgnoreCase("Empty")) {
				System.err.println("Invalid ID name. Please re-enter");
				sc.close();

			}
			// checking whether the id plate number already exits
			for (int i = 0; i < vehicle.length; i++) {

				if (idPlate.equalsIgnoreCase(vehicle[i].ID)) {

					System.out.println(" ");
					System.out.println("Car with ID:" + vehicle[i].ID + " is already in system.");
					System.out.println("Press A to add another vehicle or Z to return to the Vehicle Selecting Menu ");
					String option2 = sc.next();

					// selecting whether user want to add another vehicle or
					// return to vehicle selecting menu
					if (option2.equalsIgnoreCase("A")) {
						addCar();
					} else if (option2.equalsIgnoreCase("Z")) {
						addVehicle();
					} else {
						System.out.println(" ");
						System.err.println("Invalid input going back to last saved Point");
						System.out.println(" ");
						addCar();
					}
				}
				// if vehicle id doesn't exists
				else if (vehicle[i].ID.equalsIgnoreCase("Empty")) {

					System.out.println(" ");
					System.out.println("Parking slot is available for the car with ID: " + idPlate);
					System.out.println("Press A to confirm.");
					System.out.println("press B to go back");
					System.out.println("press Z to go back to Vehicle type Selection");
					System.out.println("Press X to exit from the system");

					String option3 = sc.next();
					// User selected to the add car to the park
					if (option3.equalsIgnoreCase("A")) {

						System.out.println(" ");
						System.out.println("Please enter the Time(24-hour format ONLY): ");
						// Get the time in hourly format
						System.out.println("Entry Hour: ");
						vehicle[i].inHour = sc.nextInt();
						System.out.println("Entry minute:");
						vehicle[i].inMin = sc.nextInt();

						// time validation
						while (vehicle[i].inHour < 0 || vehicle[i].inHour > 23 || vehicle[i].inMin < 0
								|| vehicle[i].inMin > 59) {

							System.err.println("You have entered invalid Time");
							System.out.print("Please enter the Time:");
							System.err.println("(24-hour format numerics ONLY)");
							System.out.println("Entry Hour:");
							vehicle[i].inHour = sc.nextInt();
							System.out.println("Entry Minute:");
							vehicle[i].inHour = sc.nextInt();

							// Check again the time
							if (!(vehicle[i].inHour < 0 || vehicle[i].inHour > 23 || vehicle[i].inMin < 0
									|| vehicle[i].inMin > 59)) {
								break;
							}

						}
						// time validation
						if (!(vehicle[i].inHour <= 0 || vehicle[i].inHour > 23 || vehicle[i].inMin < 0
								|| vehicle[i].inMin > 59)) {

							// registering
							vehicle[i].ID = idPlate;
							vehicle[i].type = "Car";
							System.out.println(" ");
							System.out.println("Car with ID: " + idPlate + " successfully added.");
							System.out.println("Returning to Add Car Menu.");
							addCar();
						}

					}
					// user selects to go back to add car menu
					if (option3.equalsIgnoreCase("B")) {
						System.out.println(" ");
						System.out.println(" Going Back to Add Car menu");
						System.out.println(" ");
						addCar();
					}
					// user selected to go back to the Vehicle type selection
					else if (option3.equalsIgnoreCase("Z")) {
						System.out.println(" ");
						System.out.println(" Going Back to select Vehicle type menu");
						System.out.println(" ");
						addVehicle();
					}

				}

			}

		}

		// USER selected to go back to select vehicle type
		else if (option.equalsIgnoreCase("Z")) {
			addVehicle();
		}
		// user selected to terminate the program
		else if (option.equalsIgnoreCase("X")) {
			System.out.println(" ");
			System.out.println("System exits");
			System.exit(0);
		}
		// invalid input
		else {
			System.out.println(" ");
			System.err.println("Invalid Input. Going back to Last saved Point (Add Car menu.) ");
			System.out.println(" ");
			addCar();
		}

	}

	// addCar method is for user to add Vans
	public void addVan() {

		// slotcount for count the slots available
		int slotCount = 0;
		// tempid for add to the tempslot Vans id plate number
		String[] tempID = new String[2];

		int iterate = 0;

		Scanner sc = new Scanner(System.in);

		// Add motorbike menu
		System.out.println(" ");
		System.out.println(" You have selected to add a Car (press x to exit)");
		System.out.println(" ");
		System.out.println("Press A to proceed or Z to return to Vehicle Addition Menu");

		String option = sc.next();
		// option for selecting the users response to proceed or go back
		if (option.equalsIgnoreCase("A")) {

			System.out.println(" ");
			System.out.println("Please enter the vehicle ID plate Number");
			// getting the id plate number
			String idPlate = sc.next();

			// checking whether the id plate number already exits
			for (int i = 0; i < vehicle.length; i++) {

				if (vehicle[i].ID.equalsIgnoreCase(idPlate)) {

					System.out.println(" ");
					System.out.println("Bike with ID:" + vehicle[i].ID + " is already in system.");
					System.out.println("Press A to add another vehicle or Z to return to the Vehicle selecting Menu  ");
					String option2 = sc.next();

					/*
					 * selecting whether user want to add another vehicle or
					 * return to vehicle selecting menu
					 */
					if (option2.equalsIgnoreCase("A")) {
						System.out.println(" ");
						addVan();
					} else if (option2.equalsIgnoreCase("X")) {
						System.out.println(" ");
						addVehicle();
					} else {
						System.out.println(" ");
						System.err.println("Invalid input. Going back to last saved point ");
						addVan();
					}

				}
				/*
				 * this will find how many slots are aveilable and van needs two
				 * parking slots and this will show if there are two slots
				 * aveilable for parking
				 */
				if ((vehicle[i].ID.equalsIgnoreCase("Empty"))) {
					tempID[slotCount] = vehicle[i].ID;
					slotCount++;

					if (slotCount >= 2) {
						break;
					}
				}

			}
			// if aveilable slots are less than 2 display that cannot park vans
			if (slotCount < 2) {
				System.out.println(" ");
				System.out.println("Cannot allocate space for a van");
				System.out.println("Available parking slots are Less than 2");
				System.out.println(" ");
				System.out.println("Press Z to go back to Vehicle Selection (Press x to exit the program)  ");
				String option3 = sc.next();

				if (option3.equalsIgnoreCase("Z")) {
					System.out.println(" ");
					addVehicle();
				} else if (option3.equalsIgnoreCase("X")) {
					System.out.println(" ");
					System.out.println("system ShutDown");
					System.exit(0);
				}

				else {
					System.out.println(" ");
					System.err.println("Invalid Input. Going back to last saved Point.");
					System.out.println(" ");
					addVan();

				}
			}
			// if there are 2 freeslots are available to park the van
			if (slotCount == 2) {
				System.out.println(" ");
				System.out.println("Press A to proceed to add Van with ID: " + idPlate
						+ " or press any button else to return to Add van menu");

				String option4 = sc.next();
				tempID[0] = idPlate;
				tempID[1] = idPlate;

				// user choose to add the van to park
				if (option4.equalsIgnoreCase("A")) {

					for (int j = 0; j < vehicle.length; j++) {

						if (vehicle[j].ID.equalsIgnoreCase("Empty")) {
							vehicle[j].ID = tempID[iterate];
							iterate++;
						}

						if (iterate == 2) {
							break;
						}

					}

					iterate = 0;

					System.out.println(" ");
					System.out.println("Please enter the entry hour and minute. (24-hour format numerics ONLY) ");
					System.out.println("Entry Hour: ");
					int inH = sc.nextInt();
					System.out.println("Entry minute");
					int inM = sc.nextInt();

					// Invalid input time. Do untill user input correct time
					while (inH < 0 || inH > 23 || inM < 0 || inM > 59) {

						System.err.println("You have entered invalid Time");
						System.out.print("Please enter the Time:");
						System.err.println("(24-hour format numerics ONLY)");

						System.out.println("Entry Hour:");
						inH = sc.nextInt();
						System.out.println("Entry Minute");
						inM = sc.nextInt();

						if (!(inH < 0 || inH > 23 || inM < 0 || inM > 59)) {
							break;
						}
					}

					for (int k = 0; k < vehicle.length; k++) {

						if (vehicle[k].ID.equalsIgnoreCase(idPlate)) {
							vehicle[k].inHour = inH;
							vehicle[k].inMin = inM;
							vehicle[k].type = "Van";
						}

					}

					// Display van added to the system successfully
					System.out.println(" ");
					System.out.println("Van added successfully. ");
					System.out.println("Returning back to van addition");
					addVan();

				}
				// user selected to go back to the add van menu
				else {
					System.out.println(" ");
					System.out.println(" You have selcted not to add Van to the system.");
					System.out.println("Going back to add van menu");
					System.out.println(" ");
					addVan();
				}

			}

		}

		// USER selected to go back to select vehicle type
		else if (option.equalsIgnoreCase("Z")) {
			addVehicle();
		}
		// user selected to terminate the program
		else if (option.equalsIgnoreCase("X")) {
			System.out.println(" ");
			System.out.println("System exits");
			System.exit(0);
		}
		// invalid input
		else {
			System.out.println(" ");
			System.err.println("Invalid Input. Going back to Last saved Point (Add Van menu.) ");
			System.out.println(" ");
			addVan();
		}

	}
	// elfneownfoiwenfioenw done

	// addCar method is for user to add Bikes
	public void addBike() {

		Scanner sc = new Scanner(System.in);

		// display add car input menu
		System.out.println(" ");
		System.out.println(" You have selected to add a MotorBike (press x to exit)");
		System.out.println(" ");
		System.out.println("Press A to proceed or Z to return to Vehicle Selecting Menu");

		// option for selecting the users response to proceed or go back
		String option = sc.next();

		if (option.equalsIgnoreCase("A")) {

			System.out.println("Please enter the vehicle ID plate Number");
			// getting the id plate number
			String idPlate = sc.next();

			// Checking the id plate number
			if (idPlate.equalsIgnoreCase("Empty")) {
				System.err.println("Invalid ID name. Please re-enter");
				sc.close();

			}
			// checking whether the id plate number already exits
			for (int i = 0; i < vehicle.length; i++) {

				if (idPlate.equalsIgnoreCase(vehicle[i].ID)) {

					System.out.println(" ");
					System.out.println("MotorBike with ID:" + vehicle[i].ID + " is already in system.");
					System.out.println("Press A to add another vehicle or Z to return to the Vehicle Selecting Menu ");
					String option2 = sc.next();

					// selecting whether user want to add another vehicle or
					// return to vehicle selecting menu
					if (option2.equalsIgnoreCase("A")) {
						addBike();
					} else if (option2.equalsIgnoreCase("Z")) {
						addVehicle();
					} else {
						System.out.println(" ");
						System.err.println("Invalid input going back to last saved Point");
						System.out.println(" ");
						addBike();
					}
				}
				// if vehicle id doesn't exists
				else if (vehicle[i].ID.equalsIgnoreCase("Empty")) {

					System.out.println(" ");
					System.out.println("Parking slot is available for the MotorBike with ID: " + idPlate);
					System.out.println("Press A to confirm.");
					System.out.println("press B to go back");
					System.out.println("press Z to go back to Vehicle type Selection");
					System.out.println("Press X to exit from the system");

					String option3 = sc.next();
					// User selected to the add Bike to the park
					if (option3.equalsIgnoreCase("A")) {

						System.out.println(" ");
						System.out.println("Please enter the Time(24-hour format ONLY): ");
						// Get the time in hourly format
						System.out.println("Entry Hour: ");
						vehicle[i].inHour = sc.nextInt();
						System.out.println("Entry minute:");
						vehicle[i].inMin = sc.nextInt();

						// time validation
						while (vehicle[i].inHour < 0 || vehicle[i].inHour > 23 || vehicle[i].inMin < 0
								|| vehicle[i].inMin > 59) {

							System.err.println("You have entered invalid Time");
							System.out.print("Please enter the Time:");
							System.err.println("(24-hour format numerics ONLY)");
							System.out.println("Entry Hour:");
							vehicle[i].inHour = sc.nextInt();
							System.out.println("Entry Minute:");
							vehicle[i].inHour = sc.nextInt();

							// Check again the time
							if (!(vehicle[i].inHour < 0 || vehicle[i].inHour > 23 || vehicle[i].inMin < 0
									|| vehicle[i].inMin > 59)) {
								break;
							}

						}
						// time validation
						if (!(vehicle[i].inHour <= 0 || vehicle[i].inHour > 23 || vehicle[i].inMin < 0
								|| vehicle[i].inMin > 59)) {

							// registering
							vehicle[i].ID = idPlate;
							vehicle[i].type = "Bike";
							System.out.println(" ");
							System.out.println("Car with ID: " + idPlate + " successfully added.");
							System.out.println("Returning to Add MotorBike Menu.");
							addBike();
						}

					}
					// user selects to go back to add Bike menu
					if (option3.equalsIgnoreCase("B")) {
						System.out.println(" ");
						System.out.println(" Going Back to Add Bike menu");
						System.out.println(" ");
						addBike();
					}
					// user selected to go back to the Vehicle type selection
					else if (option3.equalsIgnoreCase("Z")) {
						System.out.println(" ");
						System.out.println(" Going Back to select Vehicle type menu");
						System.out.println(" ");
						addVehicle();
					}

				}

			}

		}
		// USER selected to go back to select vehicle type
		else if (option.equalsIgnoreCase("Z")) {
			addVehicle();
		}
		// user selected to terminate the program
		else if (option.equalsIgnoreCase("X")) {
			System.out.println(" ");
			System.out.println("System exits");
			System.exit(0);
		}
		// invalid input
		else {
			System.out.println(" ");
			System.err.println("Invalid Input. Going back to Last saved Point (Add MotorBike menu.) ");
			System.out.println(" ");
			addBike();
		}

	}

	// searchType is for to select the search type
	public void searchType() {

		Scanner sc = new Scanner(System.in);

		// display search menu
		System.out.println(" ");
		System.out.println("Selected Vehicle Search (press x to exit the program)");
		System.out.println(" ");
		System.out.println("  Press T to activate Time search ");
		System.out.println("  Press I to activate vehicle plate ID search ");
		System.out.println("  Press z to go back to main menu");
		String option = sc.next();

		// user hacve selected time search
		if (option.equalsIgnoreCase("T")) {
			timeSearch();
		}
		// user hacve selected ID search
		else if (option.equalsIgnoreCase("I")) {
			idSearch();
		}
		// user hacve selected to go back to main menu
		else if (option.equalsIgnoreCase("Z")) {
			menu();
		}
		// user hacve selected exit the program
		else if (option.equalsIgnoreCase("X")) {
			System.out.println(" ");
			System.out.println("System Exits");
			System.exit(0);
		}
		// if user input anything else
		else {
			System.err.println("Invalid Input. going back to last saved point");
			searchType();
		}

	}

	// User have selected the time search
	public void timeSearch() {
		// isEmpty for get the vehicle is on the list or not
		boolean isEmpty = false;

		Scanner sc = new Scanner(System.in);
		// time selection menu
		System.out.println(" ");
		System.out.println("Selected Search by Time (press x to exit)");
		System.out.println(" ");
		System.out.println("Press A to proceed or Z to go back to Search menu");
		System.out.println(" ");
		String option = sc.next();

		// user selected to proceed
		if (option.equalsIgnoreCase("A")) {

			System.out.println("Please enter the vehicle parked hour:");
			int searchHour = sc.nextInt();
			System.out.println("Please enter the vehicle parked minute:");
			int searchMin = sc.nextInt();

			// enterd time validation
			if (searchHour < 0 || searchHour > 23 || searchMin < 0 || searchMin > 59) {

				System.err.println("You have entered invalid Time");
				System.out.print("Please enter the Time:");
				System.err.println("(24-hour format numerics ONLY)");
				timeSearch();

			}

			else if (!(searchHour < 0 || searchHour > 23 || searchMin < 0 || searchMin > 59)) {
				// search through the list
				for (int i = 0; i < vehicle.length; i++) {

					if (vehicle[i].inHour == searchHour && vehicle[i].inMin == searchMin) {
						System.out.println("Vehicle ID : " + vehicle[i].ID);
						System.out.println("Vehicle Type :" + vehicle[i].type);
						System.out.println(" ");
						isEmpty = true;
						break;
					}

				}
				// vehicle isnt on the list
				if (isEmpty == false) {
					System.out.println(" ");
					System.out.println("There isnt a vehicle parked at that time.");
					System.out.println(" ");
				}

				System.out.println(" ");
				System.out.println("Press A for search again or Z to return to search menu");
				System.out.println("Press Z for to go back to search menu ");
				System.out.println("Press X Exit the program");
				String option2 = sc.next();

				// go back to time based search
				if (option2.equalsIgnoreCase("A")) {
					timeSearch();
				}
				// go back to search type
				else if (option2.equalsIgnoreCase("Z")) {
					searchType();
				}
				// system exit
				else if (option2.equalsIgnoreCase("X")) {
					System.out.println("");
					System.exit(0);
				} else {
					System.err.println("Invalid Input. going back to last saved point");
					timeSearch();
				}

			}
			// invalid input
			else {

				System.err.println(" ");
				System.err.println("Invalid in put, going back to last saved point");
				System.err.println(" ");
				timeSearch();
			}

		}

		else if (option.equalsIgnoreCase("Z")) {
			System.out.println(" ");
			searchType();
		} else if (option.equalsIgnoreCase("X")) {
			System.out.println(" program exit");
			System.exit(0);
		}

		else {
			System.err.println("Invalid in put, going back to last saved point");
			timeSearch();

		}

	}

	// This is for to search by the id
	public void idSearch() {

		String searchID;
		boolean isEmpty = false;
		int count = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("Selected Search by ID (press x to exit) ");
		System.out.println(" ");
		System.out.println("Press A to proceed or Z to go back to menu.");
		String option = sc.next();

		if (option.equalsIgnoreCase("A")) {
			System.out.println(" ");
			System.out.println("Please enter the vehicle ID:");
			searchID = sc.next();

			for (int i = 0; i < vehicle.length; i++) {

				if (vehicle[i].ID.equalsIgnoreCase(searchID)) {

					System.out.println(" ");
					System.out.println("Vehicle ID: " + searchID);
					System.out.println("Vehicle Type: " + vehicle[i].type);
					System.out.println("Entry time: " + vehicle[i].inHour + ":" + vehicle[i].inMin);
					break;

				}

				else {
					count++;
					if (count == (vehicle.length - 1)) {
						System.out.println(" ");
						System.out.println("Vehicle with ID: " + searchID + " is not allocated in the system");
						break;
					}
				}

			}

			count = 0;

			System.out.println(" ");
			System.out.println("Press A to search another vehicle or any button to return to search menu");
			String option2 = sc.next();

			if (option2.equalsIgnoreCase("A")) {
				idSearch();
			}

			else {
				searchType();
			}

		}

		else if (option.equalsIgnoreCase("Z")) {
			searchType();

		}

		else {
			System.err.println("Invalid in put, going back to last saved point");
			idSearch();
		}

	}

	public void removeVehicle() {

		Scanner sc = new Scanner(System.in);
		String back;
		String remove;
		int check = 0;
		int num = 0;
		int count = 0;
		int hour = 0;
		int min = 0;
		int diffhour = 0;
		int diffmin = 0;
		int difftime = 0;
		int entryhour = 0;
		int entrymin = 0;
		int price = 0;
		String[] tempslot = new String[2];
		tempslot[0] = "Empty";
		tempslot[1] = "Empty";

		System.out.println(" ");
		System.out.println(" Selected Remove Vehicle (press x to exit)");
		System.out.println(" ");
		System.out.println("Press A to proceed or Z to return to the main menu.");
		String option = sc.next();

		if (option.equalsIgnoreCase("A")) {
			System.out.println(" ");
			System.out.println("Please enter the ID of the vehicle that needs to be removed");

			remove = sc.next();

			while (remove.equalsIgnoreCase("Empty")) {
				System.err.println("Invalid id, going back to last saved point");
				remove = sc.next();

				if (!(remove.equalsIgnoreCase("Empty"))) {
					break;
				}
			}

			if (!(remove.equalsIgnoreCase("Empty"))) {

				for (int i = 0; i < vehicle.length; i++) {

					if (vehicle[i].ID.equalsIgnoreCase(remove)) {

						System.out.println("");
						System.out.println("Vehicle ID: " + vehicle[i].ID);
						System.out.println("Vehicle Type: " + vehicle[i].type);
						System.out.println("Vehicle Entry Time : " + vehicle[i].inHour + vehicle[i].inMin + "h");
						tempslot[check] = vehicle[i].ID;
						check++;
					}

					else {
						count++;

						if (count >= 19) {
							System.out.println(
									"Vehicle with ID: " + remove + " not found. Returning vehicle removal menu");
							count = 0;
							removeVehicle();
							break;
						}
					}

				}
				count = 0;

				check = 0;

				if (!(tempslot[0].equalsIgnoreCase("Empty")) && !(tempslot[1].equalsIgnoreCase("Empty"))) {
					System.out.println(" ");
					System.out.println("Press R to remove the vehicle with ID: " + remove
							+ " or press any button else to return to vehicle removal menu");
					String option2 = sc.next();

					if (option2.equalsIgnoreCase("R")) {
						System.out.println(" ");
						System.out.println("Please enter the departure hour and minute (24H format only)");
						System.out.println("Departure Hour:");
						hour = sc.nextInt();
						System.out.println("Departure Minute: ");
						min = sc.nextInt();

						while (hour < 0 || hour > 23 || min < 0 || min > 59) {
							System.err.println("You have entered invalid Time");
							System.out.print("Please enter the Time:");
							System.err.println("(24-hour format numerics ONLY)");
							System.out.println("Departure Hour: ");
							hour = sc.nextInt();
							System.out.println("Departure Minute:  ");
							min = sc.nextInt();

							if (!(hour < 0 || hour > 23 || min < 0 || min > 59)) {
								break;
							}
						}

						for (int j = 0; j < vehicle.length; j++) {

							if (vehicle[j].ID.equals(tempslot[num])) {
								vehicle[j].ID = "Empty";
								vehicle[j].type = "";
								entryhour = vehicle[j].inHour;
								entrymin = vehicle[j].inMin;
								vehicle[j].inHour = 0;
								vehicle[j].inMin = 0;
								num++;

								if (num >= 1) {
									break;
								}

							}

						}
						num = 0;

						diffhour = hour - entryhour;
						diffmin = min - entrymin;

						if (diffhour >= 3 && (diffmin == 0 || min > entrymin)) {

							price = (charge * 3) + (1 * ((diffhour - 3) - (diffmin / 60)));

						}

						else if (diffhour == 23 && diffmin == 59) {

							price = 30;

						}

						else if ((diffhour < 3 && diffhour > 0) && (diffmin >= 0 || min < entrymin || min > entrymin)) {
							price = charge * ((diffhour) - (diffmin / 60));
						}

						System.out.println(" ");
						System.out.println("ID: " + tempslot[0] + " was successfully removed");
						System.out.println("Total Parking charge:  " + price + " Pounds");
						System.out.println("Press any key to return to vehicle removal menu");
						back = sc.next();
						tempslot[0] = "Empty";
						tempslot[1] = "Empty";
						removeVehicle();

					}

					else {
						removeVehicle();
					}

				}

				else if (!(tempslot[0].equalsIgnoreCase("Empty"))) {

					System.out.println(" ");
					System.out.println("Press R to remove the vehicle with ID: " + remove
							+ " or press any button else to return to vehicle removal menu");
					String option2 = sc.next();

					if (option2.equalsIgnoreCase("R")) {
						System.out.println(" ");
						System.out.println("Please enter the departure hour and minute (24H format only");
						System.out.println("Departure Hour:");
						hour = sc.nextInt();
						System.out.println("Entry Minute: ");
						min = sc.nextInt();

						while (hour < 0 || hour > 23 || min < 0 || min > 59) {
							System.err.println("You have entered invalid Time");
							System.out.print("Please enter the Time:");
							System.err.println("(24-hour format numerics ONLY)");
							System.out.println("Departure Hour: ");
							hour = sc.nextInt();
							System.out.println("Departure Minute:  ");
							min = sc.nextInt();

							if (!(hour < 0 || hour > 23 || min < 0 || min > 59)) {
								break;
							}
						}

						for (int j = 0; j < vehicle.length; j++) {

							if (vehicle[j].ID.equals(tempslot[0])) {
								vehicle[j].ID = "Empty";
								vehicle[j].type = "";
								entryhour = vehicle[j].inHour;
								entrymin = vehicle[j].inMin;
								vehicle[j].inHour = 0;
								vehicle[j].inMin = 0;
							}

						}

						if (inHour > hour) {

							diffhour = (entryhour - hour) + 20;

							if (inMin >= min) {
								diffmin = (entrymin - min) + 20;
							}

							else if (inMin < min) {
								diffmin = (min - entrymin);
							}

							price = (charge * 3) + (1 * (diffhour - 3)) + (1 * (diffmin / 60));

						}

						diffhour = hour - entryhour;
						diffmin = min - entrymin;

						if (diffhour > 3 && (min >= entrymin)) {

							price = (charge * 3) + (1 * (diffhour - 3)) + (1 * (diffmin / 60));

						}

						else if (diffhour <= 3 && (diffmin != 0 || min < entrymin)) {

							price = (charge * diffhour) + (charge * (diffmin / 60));

						}

						else if (diffhour == 23 && diffmin == 59) {

							price = 30;

						}

						System.out.println(" ");
						System.out.println(" ID: " + tempslot[0] + " was successfully removed");
						System.out.println("Total Parking charge:  " + price + " Pounds");
						System.out.println("Press any key to return to vehicle removal menu");
						back = sc.next();
						tempslot[0] = "Empty";
						tempslot[1] = "Empty";
						removeVehicle();

					}

					else {
						removeVehicle();
					}

				}

			}

		}
		else if (option.equalsIgnoreCase("Z")) {
			menu();
		}
		else if (option.equalsIgnoreCase("X")) {
			System.exit(0);
		}

		else {
			System.err.println("Invalid in put, going back to last saved point");
			removeVehicle();
		}

	}

	public void viewVehicle() {

		VehicleOb temp = new VehicleOb();
		boolean swap = false;
		Scanner sc = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("vehicles in chronological order:  ");
		System.out.println(" ");

		for (int i = 0; i < vehicle.length; i++) {

			for (int j = 1; j < vehicle.length - 1; j++) {

				if (!((vehicle[j].inHour < vehicle[j + 1].inHour && vehicle[j].inMin < vehicle[j + 1].inMin)
						|| (vehicle[j].inHour < vehicle[j + 1].inHour)
						|| (vehicle[j].inHour == vehicle[j + 1].inHour && vehicle[j].inMin < vehicle[j].inMin))) {

					temp.ID = vehicle[j].ID;
					temp.inHour = vehicle[j].inHour;
					temp.inMin = vehicle[j].inHour;
					temp.type = vehicle[j].type;
					vehicle[j].ID = vehicle[j + 1].ID;
					vehicle[j].inHour = vehicle[j + 1].inHour;
					vehicle[j].inMin = vehicle[j + 1].inMin;
					vehicle[j].type = vehicle[j + 1].type;
					vehicle[j + 1].ID = temp.ID;
					vehicle[j + 1].inHour = temp.inHour;
					vehicle[j + 1].inMin = temp.inHour;
					vehicle[j + 1].type = temp.type;
				}

			}

		}

		for (int j = 0; j < vehicle.length; j++) {

			if (!vehicle[j].ID.equalsIgnoreCase("Empty")) {
				System.out.println(" Vehicle ID: " + vehicle[j].ID);
				System.out.println("Vehicle Entry Time: " + vehicle[j].inHour + vehicle[j].inMin + "h");
				System.out.println("Vehicle Type: " + vehicle[j].type);
				System.out.println(" ");

			}

		}

		System.out.println("Press Z to return to main menu");
		String option = sc.next();

		if (option.equalsIgnoreCase("Z")) {
			menu();
		} else {
			menu();
		}
	}

}