-- begin DDCDV_ENTITY_ATTRIBUTE_DV
create table DDCDV_ENTITY_ATTRIBUTE_DV (
    ID uniqueidentifier,
    VERSION integer not null,
    CREATE_TS datetime2,
    CREATED_BY varchar(50),
    UPDATE_TS datetime2,
    UPDATED_BY varchar(50),
    DELETE_TS datetime2,
    DELETED_BY varchar(50),
    ENTITY varchar(255),
    ENTITY_ATTRIBUTE varchar(255),
    --
    VALUE_ varchar(max),
    TYPE_ varchar(50) not null,
    --
    primary key nonclustered (ID)
)^
-- end DDCDV_ENTITY_ATTRIBUTE_DV
