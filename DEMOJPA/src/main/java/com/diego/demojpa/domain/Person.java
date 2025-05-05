package com.diego.demojpa.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personas")
@EqualsAndHashCode(exclude = {"role"})
@ToString(exclude = {"role"})
// @ToString(exclude = {"role", "pasport"}) //alternativa a EqualsAndHashCode y ToString, pero no se puede usar en el mismo lado de la relación
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", columnDefinition = "TEXT", length = 50, nullable = false)
    private String name;
    private String lastName;

    @Column(name = "programing_language")
    private String language;

    @ManyToOne(cascade = CascadeType.ALL) //cascade = CascadeType.ALL, si se elimina el rol se eliminan las personas asociadas
    //cascade = CascadeType.PERSIST, si se elimina el rol no se eliminan las personas asociadas
    @JoinColumn(name = "Rol_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //eliminar el rol y las personas asociadas
    @JsonBackReference //marcar el lado que no se serializa
    // @JsonIgnore //alternativa a JsonBackReference, pero no se puede usar en el mismo lado de la relación
    private Rol role;

    @OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private pasport pasport;

    @ManyToMany
    @JoinTable(name = "person_project",
            joinColumns = @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "fk_person_id_project")),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    @JsonBackReference
    private List<project> projects = new ArrayList<>();

    public Person() {
    }
    
    public Person(Long id, String name, String lastName, String language) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
    }
}
