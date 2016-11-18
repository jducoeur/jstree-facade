# jstree-facade
A Scala.js facade for the jsTree jQuery library

## Installing the library

To use jstree-facade, add this line to your libraryDependencies:
```
"org.querki" %%% "jstree-facade" % "0.5"
```
This will include the .js file into your -jsdeps.js, and the minimized version into your -jsdeps.min.js in FullOpt builds.

There is one important constraint when using jsTree, though: the library assumes that you have a CSS "theme" included as well, or things won't display correctly. For the moment, the easiest way to deal with this is to include the desired theme explicitly in your HTML page, as something like this:
```
    <link rel="stylesheet" href="//cdn.jsdelivr.net/webjars/org.webjars/jstree/3.2.1/themes/default/style.min.css">
```
Adjust as needed for your environment. Note that there are two themes available by default -- poke around in the jstree archive at WebJars to look at the alternatives.

## About this facade

This is currently partial, to say the least -- jsTree is a pretty huge and complex Widget, and I've only implemented some of the pieces that I need so far. Pull requests are welcome to flesh it out further.

For more information about jsTree itself, including detailed information about the API and how to use it, see the [jsTree homepage](https://www.jstree.com/), and [the GitHub repo](https://github.com/vakata/jstree).
