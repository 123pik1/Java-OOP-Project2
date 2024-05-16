#!/bin/python3

import random

width = input()
height = input()

species = {
    # "Human":
    # {
    #     "health": 5,
    #     "symbol": "H",
    #     "cooldown": 0
    # },
    "Sheep":
    {
        "health": 4,
        "symbol": "S"
    },
    "Wolf":
    {
        "health": 9,
        "symbol": "W"
    },
    "Fox":
    {
        "health": 3,
        "symbol": "F"
    },
    "Turtle":
    {
        "health": 2,
        "symbol": "T"
    },
    "Antelope":
    {
        "health": 4,
        "symbol": "A"
    },
    # "CyberSheep":
    # {
    #     "health": 11,
    #     "symbol": "C"
    # },
    "Grass":
    {
        "health": 0,
        "symbol": "G"
    },
    "Guarana":
    {
        "health": 0,
        "symbol": "U"
    },
    "SosnowskyHogweed":
    {
        "health": 10,
        "symbol": "O"
    },
    "Belladonna":
    {
        "health": 99,
        "symbol": "B"
    },
    "Sonchus":
    {
        "health": 0,
        "symbol": "M"
    },
}

# if random_species == "Human":
#         print(x, y, species[random_species]["health"],random.randint(0,20), species[random_species]["symbol"], species[random_species]["cooldown"] )
#     else:


print (width, height)
print (random.randint(0, int(width)), random.randint(0, int(height)),5,random.randint(0,20), "H", 0 )
for i in range(0,20):
    x = random.randint(0, int(width))
    y = random.randint(0, int(height))
    random_species = random.choice(list(species.keys()))
    print(x, y, species[random_species]["health"],random.randint(0,20), species[random_species]["symbol"] )