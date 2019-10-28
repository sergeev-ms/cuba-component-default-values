package de.diedavids.cuba.defaultvalues.web.screens;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.MessageTools;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.defaultvalues.entity.DefaultValueConfiguration;
import de.diedavids.cuba.defaultvalues.entity.MetaClassEntity;
import de.diedavids.cuba.defaultvalues.metadata.MetadataDataProvider;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@LoadDataBeforeShow
@UiController("ddcdv_EntityDefaultValuesBrowse")
@UiDescriptor("entity-default-values-browse.xml")
public class EntityDefaultValuesBrowse extends Screen {

    @Inject
    protected MetadataDataProvider metadataDataProvider;


    @Inject
    protected MetadataTools metadataTools;

    @Inject
    protected MessageTools messageTools;
    @Inject
    protected Metadata metadata;

    @Install(to = "metaClassEntityDl", target = Target.DATA_LOADER)
    protected List<MetaClassEntity> loadEntities(LoadContext<MetaClassEntity> loadContext) {
        Collection<MetaClass> allPersistentMetaClasses = metadataTools.getAllPersistentMetaClasses();

        return allPersistentMetaClasses
                .stream()
                .map(metaClass -> {
                    MetaClassEntity metaClassEntity = metadata.create(MetaClassEntity.class);
                    metaClassEntity.setName(metaClass.getName());
                    metaClassEntity.setDescription(messageTools.getEntityCaption(metaClass));
                    return metaClassEntity;
                })
                .sorted(Comparator.comparing(MetaClassEntity::getDescription))
                .collect(Collectors.toList());

    }

}