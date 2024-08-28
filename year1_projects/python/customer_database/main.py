import csv
import logging
from datetime import datetime

# Configure logging
logging.basicConfig(filename='customer_data_error.log', level=logging.ERROR)


# Define a Customer class to represent a customer
class Customer:
    def __init__(self, first_name, surname, dob, address, postcode, email, phone):
        self.first_name = first_name
        self.surname = surname
        self.dob = dob
        self.address = address
        self.postcode = postcode
        self.email = email
        self.phone = phone


# Define a Data class to manage the customer data
class CustomerData:
    def __init__(self, csv_file):
        self.filename = "customers.csv"
        self.customers = []
        self.csv_file = csv_file

    # Load customer data from a CSV file
    def load_data(self):
        try:
            with open(self.filename, 'r') as file:
                reader = csv.reader(file)
                next(reader)  # skip header row
                for row in reader:
                    first_name, surname, dob_str, address, postcode, email, phone = row

                    # Handle different date formats
                    try:
                        if len(dob_str) == 4:  # If DOB is just a year
                            dob = datetime.strptime(dob_str, '%Y').date()
                        else:  # Expecting the full date format
                            dob = datetime.strptime(dob_str, '%Y-%m-%d').date()

                        customer = Customer(first_name, surname, dob, address, postcode, email, phone)
                        self.add_customer(customer)

                    except ValueError as ve:
                        logging.error(f"Error parsing date for customer {first_name} {surname}: {ve}")

        except FileNotFoundError as e:
            logging.error(str(e))

    # Add a new customer to the data
    def add_customer(self, customer):
        self.customers.append(customer)

    # Update an existing customer in the data
    def update_customer(self, first_name, surname, email, phone):
        for customer in self.customers:
            if customer.first_name == first_name and customer.surname == surname:
                customer.email = email
                customer.phone = phone
                break
        else:
            logging.error(f'Customer not found: {first_name} {surname}')

    # Delete a customer from the data
    def delete_customer(self, first_name, surname):
        for customer in self.customers:
            if customer.first_name == first_name and customer.surname == surname:
                confirm = input(
                    f'Are you sure you want to delete {customer.first_name} {customer.surname} from the data? (y/n): ')
                if confirm.lower() == 'y':
                    self.customers.remove(customer)
                    print('Customer deleted.')
                else:
                    print('Deletion cancelled.')
                break
        else:
            logging.error(f'Customer not found: {first_name} {surname}')

    # Search for a customer in the data by first name and surname
    def search_customer(self, first_name, surname):
        for customer in self.customers:
            if customer.first_name == first_name and customer.surname == surname:
                print(f'{customer.first_name} {customer.surname}\n'
                      f'DOB: {customer.dob}\n'
                      f'Address: {customer.address}, {customer.postcode}\n'
                      f'Email: {customer.email}\n'
                      f'Phone: {customer.phone}\n')
                break
        else:
            logging.error(f'Customer not found: {first_name} {surname}')

    # Save customer data to a CSV file
    def save_data(self):
        with open(self.csv_file, 'w', newline='') as file:
            writer = csv.writer(file)
            writer.writerow(['first_name', 'surname', 'dob', 'address', 'postcode', 'email', 'phone'])
            for customer in self.customers:
                writer.writerow([customer.first_name, customer.surname, customer.dob,
                                 customer.address, customer.postcode, customer.email, customer.phone])


if __name__ == '__main__':
    data = CustomerData('customers.csv')
    data.load_data()
    # Main loop
    while True:
        print('1. Add customer')
        print('2. List customers')
        print('3. Update customer')
        print('4. Delete customer')
        print('5. Search customer')
        print('6. Save and exit')
        choice = input('Enter your choice: ')

        # Switch function
        if choice == '1':
            first_name = input('Enter first name: ')
            surname = input('Enter surname: ')
            dob = input('Enter date of birth (YYYY-MM-DD): ')
            address = input('Enter address: ')
            postcode = input('Enter postcode: ')
            email = input('Enter email: ')
            phone = input('Enter phone number: ')

            # Handle date input and validation
            try:
                if len(dob) == 4:  # If DOB is just a year
                    dob = datetime.strptime(dob, '%Y').date()
                else:  # Expecting the full date format
                    dob = datetime.strptime(dob, '%Y-%m-%d').date()

                customer = Customer(first_name, surname, dob, address, postcode, email, phone)
                data.add_customer(customer)
                print('Customer added.')

            except ValueError as ve:
                print(f"Invalid date format: {ve}")

        elif choice == '2':
            for i, customer in enumerate(data.customers, start=1):
                print(f'{i}. {customer.first_name} {customer.surname}')
        elif choice == '3':
            first_name = input('Enter first name: ')
            surname = input('Enter surname: ')
            email = input('Enter email: ')
            phone = input('Enter phone number: ')
            data.update_customer(first_name, surname, email, phone)
            print('Customer updated.')
        elif choice == '4':
            first_name = input('Enter first name: ')
            surname = input('Enter surname: ')
            data.delete_customer(first_name, surname)
            print('Customer deleted.')
        elif choice == '5':
            first_name = input('Enter first name: ')
            surname = input('Enter surname: ')
            data.search_customer(first_name, surname)
        elif choice == '6':
            # Ask user for confirmation
            confirm = input('Are you sure you want to save and exit? (y/n): ')
            if confirm.lower() == 'y':
                data.save_data()
                print('Data saved.')
                break
        else:
            print('Invalid choice.')
