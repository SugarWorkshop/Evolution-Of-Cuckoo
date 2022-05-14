🌏 [简体中文](README.md) ● [English](README-en_us.md)

# Evolution Of Cuckoo 1.12

This is the development repository of the Minecraft mod The Evolution Of Cuckoo on Minecraft 1.12.2.

<img src=".\docs_images\logo.png" width="50%">

# Table Of Contents

- [Evolution Of Cuckoo 1.12](#evolution-of-cuckoo-112)
- [Table Of Contents](#table-of-contents)
- [Introduction](#introduction)
- [About Development](#about-development)
- [Features](#features)
- [How to Play](#how-to-play)
- [Development Guide](#development-guide)
    - [How to Build](#how-to-build)
    - [Working with CuckooLib](#working-with-cuckoolib)
- [Special Thanks](#special-thanks)

# Introduction

**Cuckoo Dev Team** is a development team of Minecraft Mod. The members are **friendly and morality**, they also **has
good grades in mod development**. So one of the members, [@SugarMGP](https://github.com/SugarMGP), decides to develop a
mod to **commemorate the noble moral sentiments of the team and its members**.

# About Development

EOC is maintained by Cuckoo Dev Team and the mod is still under development. There is no open-release version of this
mod for now. If you have any issues or suggestions on the mod, you can directly contact us
or [start an issue](https://github.com/SugarMGP/Evolution-Of-Cuckoo/issues).

# Features

- Minecraft Version: 1.12.2
- Forge Version: 14.23.5.2847
- Latest Stable
  Version: [![Latest-Stable](https://img.shields.io/github/v/release/SugarMGP/Evolution-Of-Cuckoo)](https://github.com/SugarMGP/Evolution-Of-Cuckoo/releases)
- Latest
  Version: [![Latest](https://img.shields.io/github/v/release/SugarMGP/Evolution-Of-Cuckoo?include_prereleases)](https://github.com/SugarMGP/Evolution-Of-Cuckoo/releases)

# How to Play

1. Make sure that you have already installed **Minecraft 1.12.2** and **Forge 14.23.5.2847**.
2. Goto **[Release Page](https://github.com/SugarMGP/Evolution-Of-Cuckoo/releases)**.
3. Choose the version you want to play.
4. Download `EOC-Build.tar` in **Assets** and extract it.
5. Copy all the `.jar` files without `-sources` and `-javadoc` to `.minecraft\mods`

# Development Guide

## How to Build

Execute the command below in the project root directory:

```
* Windows *
gradlew build

* Linux / Unix *
./gradlew build
```

Then you can find the archives in the directory `build/libs`.

**NOTICE: If you meet some compilation errors, You can try [Importing CuckooLib Repository](#working-with-cuckoolib). It
may solve your problems.**

## Working with CuckooLib

[CuckooLib](https://github.com/zi-jing/CuckooLib) is a dependency library of the EOC project. It includes plenty of
reusable code which is used by Cuckoo Dev Team.

If you want to debug EOC more easily, or you want to debug CuckooLib with EOC, you can clone
the [CuckooLib repository](https://github.com/zi-jing/CuckooLib), then create the file `gradle.properties` in the EOC
project's root directory, add the folllowing contents:

```properties
CuckooLibIncludeBuildPath=../CuckooLib
```

In the above code, key `CuckooLibIncludeBuildPath` refers to the CuckooLib project's root path.

Save the files, refresh the Gradle project in your IDE, then the CuckooLib project will be imported.

# Special Thanks

1. The leader of Cuckoo Dev Team [@gonggongjohn](https://github.com/gonggongjohn)
2. The origin of the name of this mod [Evolution-Of-Knowledge](https://github.com/gonggongjohn/Evolution-Of-Knowledge)
3. May be used as a dependent library in the future [CuckooLib](https://github.com/zi-jing/CuckooLib)
4. The predecessor of this mod [Evolution-Of-Zijing](https://github.com/Wu-baozi/Evolution-Of-Zijing)
