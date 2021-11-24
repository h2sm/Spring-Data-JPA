package com.h2sm.springdatajpa.shell;

import com.h2sm.springdatajpa.entity.Client;
import com.h2sm.springdatajpa.service.clientService.ClientService;
import com.h2sm.springdatajpa.service.uiService.ConsoleUI;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;


@ShellComponent
@RequiredArgsConstructor

public class CommandShell {
    private final ClientService service;
    private final ConsoleUI ui;

    @ShellMethod(value = "get all clients", key = {"get-all"})
    public void getAllClients(){
        service.getAll().forEach(System.out::println);
    }

    @ShellMethod(value = "get client", key = {"get-cli"})
    public void getClient(@ShellOption int id) {
        var x = service.getByID(id);
        System.out.println(x);
    }

    @ShellMethod(value = "delete client", key = {"del-cli"})
    public void deleteClient(@ShellOption int id,
                             @ShellOption boolean sure) {
        if (sure) service.delete(id);
        else System.out.println("You are not sure what ya doing, so no deleting this time");

    }
    @ShellMethod(value = "modify client", key = {"mod-cli"}) //YYYY-MM-DD
    public void modifyClient(@ShellOption(value = "--id") int id) {
        var client = service.getByID(id);
        service.update(getModifiedClient(client));
    }

    @ShellMethod(value = "add client", key = {"add-cli"})
    public void addClient() {
        service.save(getNewClient());
    }

    private Client getModifiedClient(Client c){
        ui.say("Обновите имя");
        c.setFullName(ui.read());
        ui.say("Обновите паспорт");
        c.setPassport(ui.read());
        ui.say("обновите номер телефона");
        c.setPhoneNumber(ui.read());
        ui.say("обновите дату рождения: dd-MM-yyyy");
        c.setDate(ui.read());
        return c;
    }

    private Client getNewClient(){
        ui.say("Введите имя, паспорт, номер телефона и дату рождения в фортмате дд-мм-гггг. После каждого параметра нажимайте энтер");
        var client = new Client(ui.read(), ui.read(), ui.read(), ui.read());
        return client;
    }

}
