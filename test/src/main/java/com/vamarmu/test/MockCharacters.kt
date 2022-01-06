package com.vamarmu.test

import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.domain.MarvelImage
import com.vamarmu.domain.MarvelResourceList
import com.vamarmu.domain.MarvelResourceSummary



fun getMockCharacter() : MarvelCharacter = MarvelCharacter(
    id = 1001,
    name = "Vamarmu",
    description = "Android programmer. It will not stop until the bug is resolved",
    thumbnail = MarvelImage(path="http://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64", extension="jpg"),
    resourceUri=null,
    comics= MarvelResourceList(
        collectionURI = "http://gateway.marvel.com/v1/public/characters/1009149/comics", 
        items= arrayListOf(
            MarvelResourceSummary(
                resourceUri = null,
                name = "Uncanny X-Men (1963) #402",
                type = null
            ),
            MarvelResourceSummary(
                resourceUri = null,
                name = "Uncanny X-Men (1963) #404",
                type = null
            ),
            MarvelResourceSummary(
                resourceUri = null,
                name = "Uncanny X-Men (1963) #405",
                type = null
            ),
            MarvelResourceSummary(
                resourceUri = null,
                name = "Uncanny X-Men (1963) #406",
                type = null
            ),
            MarvelResourceSummary(
                resourceUri = null,
                name = "Uncanny X-Men (1963) #429",
                type = null
            ),
            MarvelResourceSummary(
                resourceUri = null,
                name = "Uncanny X-Men (1963) #431",
                type = null
            ),
            MarvelResourceSummary(resourceUri = null, name = "X-Men: Alpha (1995) #1", type = null),
        
            MarvelResourceSummary(resourceUri=null, name = "X-Men: The Complete Age of Apocalypse Epic Book 2 (Trade Paperback)", type =null)
        )
    ), 
    stories= MarvelResourceList(
        collectionURI = "http://gateway.marvel.com/v1/public/characters/1009149/stories", 
        items=arrayListOf(
            MarvelResourceSummary(resourceUri=null, name = "A Beginning", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "Utility of Myth", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "Army Ants", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "Ballroom Blitzkrieg", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "Staring Contests are for Suckers", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "The Draco Part One: Sins of the Father", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "The Draco Part Three", type = "interiorStory"), 
            MarvelResourceSummary(resourceUri=null, name = "The Draco Part Four", type = "interiorStory")
        )
    ), 
    
    events= MarvelResourceList(
        collectionURI = "http://gateway.marvel.com/v1/public/characters/1009149/events", 
        items= arrayListOf(
            MarvelResourceSummary(resourceUri=null, name = "Age of Apocalypse", type =null)
        )
    ), 
    series= MarvelResourceList(
        collectionURI = "http://gateway.marvel.com/v1/public/characters/1009149/series", 
        items= arrayListOf(
            MarvelResourceSummary(resourceUri=null, name = "Uncanny X-Men (1963 - 2011)", type =null), 
            MarvelResourceSummary(resourceUri=null, name = "X-Men: Alpha (1995)", type =null), 
            MarvelResourceSummary(resourceUri=null, name = "X-Men: The Complete Age of Apocalypse Epic Book 2 (2005)", type =null)
        )
    )
)

fun getMockCharacters() : List<MarvelCharacter> = arrayListOf(
    getMockCharacter(),
    getMockCharacter().copy(id = 1002, name = "Character 2"),
    getMockCharacter().copy(id = 1003, name = "Character 3"),
    getMockCharacter().copy(id = 1004, name = "Character 4"),
    getMockCharacter().copy(id = 1005, name = "Character 5"),
    getMockCharacter().copy(id = 1006, name = "Character 6"),
    getMockCharacter().copy(id = 1007, name = "Character 7"),

)
