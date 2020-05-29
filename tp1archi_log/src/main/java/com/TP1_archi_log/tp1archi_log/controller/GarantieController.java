package com.TP1_archi_log.tp1archi_log.controller;

import com.TP1_archi_log.tp1archi_log.model.BDDfake;
import com.TP1_archi_log.tp1archi_log.model.Garantie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GarantieController {

    private final AtomicLong counter = new AtomicLong();

    /**
     * Requete POST qui créé une nouvelle garantie dans la base de donnée.
     * @param nom
     * @param montant
     * @param description
     * @return id de la garantie créé
     */
    @PostMapping("/api/garantie")
    public ResponseEntity<Integer> addGarantie(@RequestParam("nom") String nom,
                                               @RequestParam("montant") int montant,
                                               @RequestParam("description") String description)
    {
        Garantie garantie = new Garantie(BDDfake.seq.getAndIncrement(), nom, montant, description);
        BDDfake.bddfake.put(garantie.getId(), garantie);

        return ResponseEntity.ok().body(garantie.getId());
    }


    /**
     * Requete DELETE qui supprime une garantie en tapant l'ID spécifique
     * @param id
     */

    @DeleteMapping("/api/garantie/{id}")
    public ResponseEntity<Garantie> dropGarantie(@PathVariable("id") int id)
    {
        if (BDDfake.bddfake.containsKey(id)){
            BDDfake.bddfake.remove(id);
            System.out.println("Garantie avec l'ID n° " + id + " supprimée.");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Requete GET pour afficher toutes les garanties
     */
    @GetMapping("/api/garantie")
    public ResponseEntity<Collection<Garantie>> listGarantie(){
        System.out.println("Liste des garanties : \n");
        return ResponseEntity.ok().body(BDDfake.bddfake.values());
    }

    /**
     * Requete GET pour afficher une description et le montant d'une garantie dont on tape l'ID
     * @param id
     */
    @GetMapping("/api/garantie/{id}")
    public ResponseEntity<Garantie> getGarantieInfo(@PathVariable("id") int id){
        if(BDDfake.bddfake.containsKey(id)){
            Garantie garantie = BDDfake.bddfake.get(id);
            return ResponseEntity.ok().body(garantie);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/garantie/{id}")
    public ResponseEntity<Garantie> updateGarantie(@PathVariable("id") int id, @RequestBody Garantie garantie){
        if(BDDfake.bddfake.containsKey(id)){
            BDDfake.bddfake.put(id,garantie);
            System.out.println("Mise à jour de la garantie : " + garantie);

            return ResponseEntity.ok().body(garantie);
        }

        return ResponseEntity.notFound().build();
    }


}
