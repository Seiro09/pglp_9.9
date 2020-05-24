package fr.uvsq21504875;

import java.util.List;

public abstract class DAO<T> {

  /**
   * Méthode de création d'objet T.
   *
   * @param obj L'objet à créer dans la base de données.
   * @return L'objet créé.
   */
  public abstract T create(T obj);

  /**
   * Méthode de recherche d'objet T.
   *
   * @param id Le paramètre d'identification de l'objet.
   * @return L'objet trouvé (ou null).
   */
  public abstract T find(String id);

  /**
   * Méthode permettant de récupérer le contenu d'une table.
   *
   * @return La liste des objets de la base de données.
   */
  public abstract List<T> findAll();

  /**
   * Méthode de mise à jour de la base de données.
   *
   * @param obj L"objet à mettre à jour.
   * @return L'objet modifié.
   */
  public abstract T update(T obj);

  /**
   * Méthode de suppression de la base de données.
   *
   * @param obj L"objet à supprimer.
   */
  public abstract void delete(T obj);
}
