package br.com.gold_ear.controller;

import br.com.gold_ear.model.usuario.Membro;
import br.com.gold_ear.service.MembroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/membros")
@Tag(name = "Membro", description = "Path relacionado aos membros da plataforma")
public class MembroController {

    private final MembroService membroService;

    @Autowired
    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @Operation(summary = "Adicionar novo membro")
    @PostMapping("/criar")
    public ResponseEntity<Membro> criarMembro(@RequestBody Membro membro) {
        Membro membroSalvo = membroService.salvarMembro(membro);
        return new ResponseEntity<>(membroSalvo, HttpStatus.CREATED);
    }

    @Operation(summary = "Buscar membro pelo ID")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Membro> buscarPorId(@PathVariable Long id) {
        Optional<Membro> membro = membroService.buscarPorId(id);
        return membro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Listar todos os membros")
    @GetMapping
    public ResponseEntity<List<Membro>> buscarTodos() {
        List<Membro> membros = membroService.buscarTodos();
        return ResponseEntity.ok(membros);
    }

    @Operation(summary = "Atualizar membro pelo ID")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Membro> atualizarMembro(@PathVariable Long id, @RequestBody Membro membro) {
        try {
            Membro membroAtualizado = membroService.atualizarMembro(id, membro);
            return ResponseEntity.ok(membroAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Excluir membro pelo ID")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirMembro(@PathVariable Long id) {
        try {
            membroService.excluirMembro(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
