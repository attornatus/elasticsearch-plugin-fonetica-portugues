# Phonetic plugin português para ElasticSearch

A Phonetic plugin para português é baseado no Phonetic Analysis plugin.

## Instação

A instalação do plugin deve ser feita de forma offline, conforme o site do elasticsearch.
[https://www.elastic.co/guide/en/elasticsearch/plugins/6.1/plugin-management-custom-url.html]
    
    sudo bin/elasticsearch-plugin install file:///path/to/elasticsearch-fonetica-portuguesa-0.0.1.zip
    
O arquivo "elasticsearch-fonetica-portuguesa-0.0.1.zip" está dentro da pasta "plugin" do projeto.     

## Configuração

Na configuração do seu index, setar comando abaixo para criação do analyser. 
```
PUT exemploindex
{
  "settings": {
    "index": {
      "analysis": {
        "analyzer": {
          "fonetico": {
            "type": "custom",
            "tokenizer": "standard",
            "filter": [
              "standard",
              "lowercase",
              "foneticaportuguesa_filter",
              "asciifolding"
            ]
          }
        },
        "filter": {
          "foneticaportuguesa_filter": {
            "type": "foneticaportuguesa"
          }
        }
      }
    }
  }
}
```
Quando você criar seu mapping do index, use o analyser criado.

No comando abaixo, é possível realizar um teste com o analyser criado
```
GET exemploindex/_analyze
{
  "analyzer": "fonetico",
  "text": "china" 
}
```

## Versões

Este plugin foi testado nas versões: 
 
 elasticsearch-fonetica-portuguesa-0.0.1.zip:

 * elasticsearch: 6.5.2
 * java.version: 1.8

elasticsearch-fonetica-portuguesa-0.0.2.zip

 * elasticsearch: 7.13.3
 * java.version: 1.8

