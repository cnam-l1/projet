#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: User
#------------------------------------------------------------

CREATE TABLE User(
        id_user   Int  Auto_increment  NOT NULL ,
        lastname  Varchar (50) NOT NULL ,
        firstname Varchar (50) NOT NULL ,
        password  Varchar (50) NOT NULL ,
        email     Varchar (100) NOT NULL
	,CONSTRAINT User_PK PRIMARY KEY (id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Recipe
#------------------------------------------------------------

CREATE TABLE Recipe(
        id_recipe Int  Auto_increment  NOT NULL ,
        name      Varchar (100) NOT NULL ,
        nb_person Int NOT NULL ,
        id_user   Int NOT NULL
	,CONSTRAINT Recipe_PK PRIMARY KEY (id_recipe)

	,CONSTRAINT Recipe_User_FK FOREIGN KEY (id_user) REFERENCES User(id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Shopping
#------------------------------------------------------------

CREATE TABLE Shopping(
        id_shopping Int  Auto_increment  NOT NULL ,
        date        Date NOT NULL ,
        id_user     Int NOT NULL
	,CONSTRAINT Shopping_PK PRIMARY KEY (id_shopping)

	,CONSTRAINT Shopping_User_FK FOREIGN KEY (id_user) REFERENCES User(id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: MesureUnit
#------------------------------------------------------------

CREATE TABLE MesureUnit(
        id_mesure_unit Int  Auto_increment  NOT NULL ,
        name           Varchar (50) NOT NULL
	,CONSTRAINT MesureUnit_PK PRIMARY KEY (id_mesure_unit)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Category
#------------------------------------------------------------

CREATE TABLE Category(
        id_category Int  Auto_increment  NOT NULL ,
        name        Varchar (50) NOT NULL
	,CONSTRAINT Category_PK PRIMARY KEY (id_category)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Ingredient
#------------------------------------------------------------

CREATE TABLE Ingredient(
        id_ingredient  Int  Auto_increment  NOT NULL ,
        name           Varchar (100) NOT NULL ,
        id_mesure_unit Int NOT NULL ,
        id_category    Int NOT NULL
	,CONSTRAINT Ingredient_PK PRIMARY KEY (id_ingredient)

	,CONSTRAINT Ingredient_MesureUnit_FK FOREIGN KEY (id_mesure_unit) REFERENCES MesureUnit(id_mesure_unit)
	,CONSTRAINT Ingredient_Category0_FK FOREIGN KEY (id_category) REFERENCES Category(id_category)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: IngreUser
#------------------------------------------------------------

CREATE TABLE IngreUser(
        id_ingredient Int NOT NULL ,
        id_user       Int NOT NULL
	,CONSTRAINT IngreUser_PK PRIMARY KEY (id_ingredient,id_user)

	,CONSTRAINT IngreUser_Ingredient_FK FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient)
	,CONSTRAINT IngreUser_User0_FK FOREIGN KEY (id_user) REFERENCES User(id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ShoppingList
#------------------------------------------------------------

CREATE TABLE ShoppingList(
        id_ingredient Int NOT NULL ,
        id_shopping   Int NOT NULL ,
        quantity      Int NOT NULL
	,CONSTRAINT ShoppingList_PK PRIMARY KEY (id_ingredient,id_shopping)

	,CONSTRAINT ShoppingList_Ingredient_FK FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient)
	,CONSTRAINT ShoppingList_Shopping0_FK FOREIGN KEY (id_shopping) REFERENCES Shopping(id_shopping)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Composition
#------------------------------------------------------------

CREATE TABLE Composition(
        id_ingredient Int NOT NULL ,
        id_recipe     Int NOT NULL ,
        quantity      Int NOT NULL
	,CONSTRAINT Composition_PK PRIMARY KEY (id_ingredient,id_recipe)

	,CONSTRAINT Composition_Ingredient_FK FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient)
	,CONSTRAINT Composition_Recipe0_FK FOREIGN KEY (id_recipe) REFERENCES Recipe(id_recipe)
)ENGINE=InnoDB;

