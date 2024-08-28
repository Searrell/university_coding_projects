lstEmployees = []
lstNames = []
counter = 0


def export_employee():
    for employee in lstEmployees:
        with open("file.txt", "w") as output:
            output.write(str(employee))


def search_uen():
    uen = input("Enter employee UEN: ")
    for employee in lstEmployees:
        if uen == employee[1]:
            print("-----------------" + employee[0] + "------------------------")
            print("UEN: " + employee[1])
            print("Phone: " + employee[2])
            print("Email: " + employee[3])
            print("Salary: £" + employee[4])
            return employee
    return -1


def edit_employee():
    search = search_uen()
    if search == -1:
        print("Employee not found...")
    else:
        name = input("Enter the new name of the employee: ")
        uen = input("Enter the new UEN of the employee: ")
        phone = input("Enter the Phone number of the employee: ")
        email = input("Enter the email of the employee: ")
        salary = input("Enter the salary of the employee: ")
        search[0] = name
        search[1] = uen
        search[2] = phone
        search[3] = email
        search[4] = salary


def add_employee():
    global counter

    print("----------------------------------------------------------\n")
    print("         Number of employee ({0:d})".format(counter))
    print("----------------------------------------------------------\n")
    name = input("enter employee name: ")
    lstNames.insert(counter, name)
    uen = input("enter employee UEN: ")
    phone = input("enter employee phone number: ")
    email = input("enter employee email: ")
    salary = input("enter employee salary: ")

    lstEmployees.append([name, uen, phone, email, salary])
    counter = counter + 1
    return


def print_employee():
    for employee in lstEmployees:
        print("-----------------" + employee[0] + "------------------------")
        print("UEN: " + employee[1])
        print("Phone: " + employee[2])
        print("Email: " + employee[3])
        print("Salary: £" + employee[4])


def main():
    while True:
        print('-------------------------------------------\n')
        print('Welcome to the Employee Management System -\n')
        print('-------------------------------------------\n')
        print('[1] Add An Employee: \n')
        print('[2] View All Employees: \n')
        print('[3] Search Employees By UEN: \n')
        print('[4] Edit Employees Information: \n')
        print('[5] Export Employee Records: \n')
        print('[6] Exit \n')
        user_option = input("Please select an option ")
        if user_option == "1":
            add_employee()
        elif user_option == "2":
            print('\n' * 3)
            print_employee()
            print('\n' * 3)
        elif user_option == "3":
            found = search_uen()
            if found == -1:
                print("Employee not found...")
        elif user_option == "4":
            edit_employee()
        elif user_option == "5":
            export_employee()
        elif user_option == "6":
            print("thank you for using the employee management system")
            exit()
        else:
            print("Please select valid option...")


if __name__ == "__main__":
    main()
