'''
PATRÓN CREACIONAL SINGLETON.

Se asegura que únicamente exista un solo objeto de este tipo, y proporciona un 
único punto de acceso para el en cualquier otro código

Vamos a aplicar un caso práctico, se simulará un caso de un "banco", viendo como el acceso
siempre se dará por el mismo objeto. 

'''
from datetime import datetime

class SingletonMeta(type):

    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]



class Bank(metaclass=SingletonMeta):
    # Constructor de la clase. Atributos: data -> Diccionario con el historial de operacciones y el dinero actual
    def __init__(self):
        self.data = {"current_money": 0, "transacction_history": []}
    
    # Metodo privado para guardar el tiempo
    def _save_time(self, context) -> None:
        transaction_time = f"Y:{datetime.now().year}//M:{datetime.now().month}//H:{datetime.now().hour}"
        self.data["transacction_history"].append((transaction_time, context))

    # Metodo publico para añadir dinero
    def add_money(self, money: int) -> None:
        self.data["current_money"] += money
        self._save_time(context=f"Added {money}")

    # Metodo publico para retirar dinero
    def retire_money(self,money: int) -> None:
        # Comprobamos que tengamos dinero
        if (self.data["current_money"] < 0):
            print(f"No se puede realizar la acción, su balance actual es de: {self.data["current_money"]}")
            return 
        
        self.data["current_money"] -= money
        self._save_time(context=f"Retired {money}")

    # Mostrar el dinero que tenemos
    def show_balance(self) -> None:
        print("Dinero total:", self.data["current_money"])

    # Mostrar el historial de transacciones
    def show_transaction_history(self) -> None:
        print("Historial de transacciones.")
        for transacction in self.data["transacction_history"]:
            print("Fecha de la operacion:", transacction[0])
            print("Operacion:", transacction[1])


    
# Flujo normal del programa
def select_bank(bank_names: list, avaiable_banks: list) -> list | None:
    # Definimos como variables todos los bancos
    print("Seleccione la sede")
    for index, bank in enumerate(bank_names):
        print(f"{index + 1}: {bank}")
    option = int(input()) - 1

    try:
        print(f"Operando con el banco: {bank_names[option]}.")
        return [avaiable_banks[option], bank_names[option]]

    except Exception as e:
        print("Error:", e)
        return None


if __name__ == "__main__":
    cuzco, delicias, sol, castellana= Bank(), Bank(), Bank(), Bank()   
    bank_names = ["Cuzco", "Delicias", "Sol", "Castellana"]
    avaiable_banks = [cuzco, delicias, sol, castellana]

    print("Bienvenido al simulador de banco")
    selected_bank = select_bank(bank_names=bank_names, avaiable_banks=avaiable_banks)
    while selected_bank == None:
        print("El banco escogido no esta en el catalogo, ingrese otro banco:")
        selected_bank = select_bank(bank_names=bank_names, avaiable_banks=avaiable_banks)


    while True:
        print("Ingrese una opcion:\n1) Ingresar dinero\n2) Retirar dinero\n3) Consultar\n4) Cambiar banco\n5) Salir")
        opcion = int(input())
        try:
            match opcion:
                case 1:
                    to_add = int(input("Ingresa dinero:"))
                    selected_bank[0].add_money(to_add)
                case 2:
                    to_retire = int(input("Ingrese cantidad a retirar:"))
                    selected_bank[0].retire_money(to_retire)
                case 3:
                    print("Balance actual:")
                    selected_bank[0].show_balance()
                    print("Historial de transacciones")
                    selected_bank[0].show_transaction_history()
                case 4:
                    new_bank = select_bank(bank_names=bank_names, avaiable_banks=avaiable_banks)
                    while new_bank == None:
                        print("El banco escogido no esta en el catalogo, ingrese otro banco:")
                        new_bank = select_bank(bank_names=bank_names, avaiable_banks=avaiable_banks)
                        while new_bank == None:
                            new_bank = select_bank(bank_names=bank_names, avaiable_banks=avaiable_banks)
                        selected_bank = new_bank


                    
                case 5:
                    print("Saliendo...")
                    break
                case _:
                    print("Opcion no válida")
        except ValueError:
            print("La opcion", opcion, "no es valida.")

    