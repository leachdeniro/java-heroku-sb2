package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/convertir", method = RequestMethod.POST)
    public Persona convertir(@RequestBody Persona persona) {
        System.out.println("nombre: " + persona.getNombre() + " ; apellido: " + persona.getApellido());
        return new Persona(persona.getNombre().toUpperCase() + " también en nombre",persona.getApellido().toUpperCase() + " un cambio menos");
    }

    @RequestMapping(value = "/mismo", method = RequestMethod.POST)
    public Persona mismo(@RequestBody Persona persona) {
        return persona;
    }
}
