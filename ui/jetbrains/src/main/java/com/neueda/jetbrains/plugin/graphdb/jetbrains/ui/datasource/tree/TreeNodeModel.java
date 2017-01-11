package com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.tree;

import com.neueda.jetbrains.plugin.graphdb.jetbrains.component.datasource.state.DataSourceApi;
import com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.metadata.dto.ContextMenu;

import javax.swing.*;
import java.util.Optional;

public class TreeNodeModel implements TreeNodeModelApi {

    private ContextMenu contextMenu;
    private NodeType type;
    private Icon icon;
    private String value;
    private DataSourceApi dataSourceApi;

    public TreeNodeModel(Neo4jTreeNodeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TreeNodeModel(Neo4jTreeNodeType type, DataSourceApi dataSourceApi, String value) {
        this.type = type;
        this.value = value;
        this.dataSourceApi = dataSourceApi;
        prepareContextMenu();
    }

    public TreeNodeModel(Neo4jTreeNodeType type, DataSourceApi dataSourceApi, String value, Icon icon) {
        this.type = type;
        this.value = value;
        this.dataSourceApi = dataSourceApi;
        this.icon = icon;
        prepareContextMenu();
    }

    public TreeNodeModel(Neo4jTreeNodeType type, DataSourceApi dataSourceApi) {
        this.type = type;
        this.dataSourceApi = dataSourceApi;
        prepareContextMenu();
    }

    private void prepareContextMenu() {
        if (type == Neo4jTreeNodeType.LABEL
            || type == Neo4jTreeNodeType.RELATIONSHIP
            || type == Neo4jTreeNodeType.PROPERTY_KEY) {
                contextMenu = new ContextMenu(type, getDataSourceApi(), value);
        }
    }

    @Override
    public Optional<ContextMenu> getContextMenu() {
        return Optional.ofNullable(contextMenu);
    }

    public void setContextMenu(ContextMenu contextMenu) {
        this.contextMenu = contextMenu;
    }

    @Override
    public NodeType getType() {
        return type;
    }

    public void setType(Neo4jTreeNodeType type) {
        this.type = type;
    }

    @Override
    public Optional<Icon> getIcon() {
        return Optional.ofNullable(icon);
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public Optional<String> getText() {
        return Optional.ofNullable(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public DataSourceApi getDataSourceApi() {
        return dataSourceApi;
    }

    public void setDataSourceApi(DataSourceApi dataSourceApi) {
        this.dataSourceApi = dataSourceApi;
    }
}