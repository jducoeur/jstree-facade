package org.querki.facades.jstree

import scala.scalajs.js
import js.annotation.{JSName, ScalaJSDefined}
import js.JSConverters._
import js.{|, undefined, UndefOr}
import org.scalajs.dom
import org.querki.jquery._
import org.querki.jsext._

/**
 * @author jducoeur
 */
@js.native
trait JsTree extends JQuery {
  @JSName("jstree")
  def jsTree():JsTree = js.native
  
  @JSName("jstree")
  def jsTree(options:JsTreeOptions):JsTree = js.native
}

/*
@ScalaJSDefined
class JsTreeOptions extends js.Object
{
  /**
   * The core options.
   */
  var core:UndefOr[JsTreeCore] = undefined
  
  /**
   * Which plugins are active for this tree.
   */
  @JSName("plugins")
  private var _plugins:UndefOr[js.Array[String]] = undefined
  
  /**
   * Strongly-typed setter for which plugins are active for this tree
   */
  def setPlugins(v:JsTreePlugin*) = _plugins = v.map(_.name).toJSArray
}
*/

@js.native
trait JsTreeOptions extends js.Object 
object JsTreeOptions extends JsTreeOptionBuilder(noOpts)
class JsTreeOptionBuilder(val dict:OptMap) extends JSOptionBuilder[JsTreeOptions, JsTreeOptionBuilder](new JsTreeOptionBuilder(_)) 
{
  /**
   * The core options.
   */
  def core(v:JsTreeCore) = jsOpt("core", v)
  
  /**
   * Which plugins are active for this tree.
   */
  def plugins(v:Seq[JsTreePlugin]) = jsOpt("plugins", v.map(_.name).toJSArray)
}

/*
@ScalaJSDefined
class JsTreeCore extends js.Object
{
  /**
   * The open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
   */
  var animation:UndefOr[Boolean | Int] = undefined
  
  /**
   * The actual data to populate this tree with. 
   * 
   * Or, the AJAX configuration for fetching the tree's data.
   * 
   * Or, function that will be called to define a node to be rendered. "this" is the node to render; the second
   * parameter is the callback to call with the rendered data. (Is this signature correct? Needs testing.)
   */
  var data:UndefOr[js.Array[JsTreeNode] | JQueryAjaxSettings | js.ThisFunction1[js.Object, js.Function2[js.Object, js.Array[JsTreeNode], Any], Any]] = undefined
  
  /**
   * Force node text to plain text (and escape HTML). Defaults to false
   */
  @JSName("force_text")
  var forceText:UndefOr[Boolean] = undefined
  
  /**
   * A boolean indicating if multiple nodes can be selected
   */
  var multiple:UndefOr[Boolean] = undefined
  
  /**
   * Theme information -- how to actually display the tree.
   * 
   * IMPORTANT: you need to include the theme information somehow! In practice, this currently means that
   * your HTML file needs to include the CSS theme that you want to use. This kinda sucks: what we really
   * want is an sbt-level way to incorporate the CSS dependency into your app.
   */
  var themes:UndefOr[JsTreeTheme] = undefined
}
*/

@js.native
trait JsTreeCore extends js.Object 
object JsTreeCore extends JsTreeCoreBuilder(noOpts)
class JsTreeCoreBuilder(val dict:OptMap) extends JSOptionBuilder[JsTreeCore, JsTreeCoreBuilder](new JsTreeCoreBuilder(_))
{
  /**
   * The open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
   */
  def animation(v:Boolean | Int) = jsOpt("animation", v)
  
  /**
   * The actual data to populate this tree with. 
   */
  def data(v:Seq[JsTreeNode]) = jsOpt("data", v.toJSArray)
  
  /**
   * The AJAX configuration for fetching the tree's data.
   */
  def data(v:JQueryAjaxSettings) = jsOpt("data", v)
  
  /**
   * Function that will be called to define a node to be rendered. This gets called with the
   * node that is being rendered, and a callback to pass in its children.
   */
  def data(func:js.Function2[js.Object, js.Function1[js.Array[JsTreeNode], Any], Any]) = jsOpt("data", func)
  
  /**
   * Force node text to plain text (and escape HTML). Defaults to false
   */
  def forceText(v:Boolean) = jsOpt("force_text", v)
  
  /**
   * A boolean indicating if multiple nodes can be selected
   */
  def multiple(v:Boolean) = jsOpt("multiple", v)
  
  /**
   * Theme information -- how to actually display the tree.
   * 
   * IMPORTANT: you need to specify the theme information somehow! In practice, this currently means that
   * your HTML file needs to include the CSS theme that you want to use. This kinda sucks: what we really
   * want is an sbt-level way to incorporate the CSS dependency into your app.
   */
  def themes(v:JsTreeTheme) = jsOpt("themes", v)
  
  /**
   * If left as true web workers will be used to parse incoming JSON data where possible, so that the UI will 
   * not be blocked by large requests. Workers are however about 30% slower. Defaults to true
   */
  def worker(v:Boolean) = jsOpt("worker", v)
}

/*
@ScalaJSDefined
class JsTreeNode extends js.Object
{
  /**
   * Object of values which will be used to add HTML attributes on the resulting A node.
   */
  @JSName("a_attr")
  var aAttr:UndefOr[js.Object] = undefined
  
  /**
   * The child nodes to display under this one.
   */
  var children:UndefOr[js.Array[JsTreeNode]] = undefined
  
  def setChildren(v:JsTreeNode*) = children = v.toJSArray 
  
  /**
   * This can be anything you want - it is metadata you want attached to the node - you will 
   * be able to access and modify it any time later - it has no effect on the visuals of the node.
   */
  var data:UndefOr[Any] = undefined
  
  /**
   * A string which will be used for the node's icon - this can either be a path to a file, or a 
   * className (or list of classNames), which you can style in your CSS (font icons also work).
   */
  var icon:UndefOr[String] = undefined
  
  /**
   * Makes if possible to identify a node later (will also be used as a DOM ID of the LI node). 
   * Make sure you do not repeat the same ID in a tree instance (that would defeat its purpose of 
   * being a unique identifier and may cause problems for jstree).
   */
  var id:UndefOr[String] = undefined
  
  /**
   * Object of values which will be used to add HTML attributes on the resulting LI DOM node.
   */
  @JSName("li_attr")
  var liAttr:UndefOr[js.Object] = undefined
  
  /**
   * Options describing the state of the node.
   */
  var state:UndefOr[NodeState] = undefined
  
  /**
   * The text to display for this node. Required.
   */
  var text:UndefOr[String] = undefined
  
  /**
   * Types plugin specific - the type of the nodes (should be defined in the types config), if not set "default" is assumed.
   */
  @JSName("type")
  var tpe:UndefOr[String] = undefined
}
*/

@js.native
trait JsTreeNode extends js.Object 
{
  val data:Any = js.native
  val id:UndefOr[String] = js.native
}
object JsTreeNode extends JsTreeNodeBuilder(noOpts)
class JsTreeNodeBuilder(val dict:OptMap) extends JSOptionBuilder[JsTreeNode, JsTreeNodeBuilder](new JsTreeNodeBuilder(_)) 
{
  /**
   * Object of values which will be used to add HTML attributes on the resulting A node.
   */
  def aAttr(v:js.Object) = jsOpt("a_attr", v)
  
  /**
   * The child nodes to display under this one.
   */
  def children(v:Seq[JsTreeNode]) = jsOpt("children", v.toJSArray)
  
  /**
   * Iff you set children to true, and define a callback function in core.data, it means that
   * this node *has* children, and the callback should be used to fetch them. Defaults to false.
   */
  def children(v:Boolean) = jsOpt("children", v)
  
  /**
   * This can be anything you want - it is metadata you want attached to the node - you will 
   * be able to access and modify it any time later - it has no effect on the visuals of the node.
   */
  def data(v:Any) = jsOpt("data", v)
  
  /**
   * If set to false, turns off showing an icon for this node.
   */
  def icon(v:Boolean) = jsOpt("icon", v)
  
  /**
   * A string which will be used for the node's icon - this can either be a path to a file, or a 
   * className (or list of classNames), which you can style in your CSS (font icons also work).
   */
  def icon(v:String) = jsOpt("icon", v)
  
  /**
   * Makes if possible to identify a node later (will also be used as a DOM ID of the LI node). 
   * Make sure you do not repeat the same ID in a tree instance (that would defeat its purpose of 
   * being a unique identifier and may cause problems for jstree).
   */
  def id(v:String) = jsOpt("id", v)
  
  /**
   * Object of values which will be used to add HTML attributes on the resulting LI DOM node.
   */
  def liAttr(v:js.Object) = jsOpt("li_attr", v)
  
  /**
   * Options describing the state of the node, drawn from NodeState.
   */
  def state(vs:NodeState*) = jsOpt("state", ((Map.empty[String, Boolean] /: vs) { (map, v) => map + (v.name -> v.set) }).toJSDictionary)
  
  /**
   * The text to display for this node. Required. May include HTML if force_text is not turned on.
   */
  def text(v:String) = jsOpt("text", v)
  
  /**
   * Types plugin specific - the type of the nodes (should be defined in the types config), if not set "default" is assumed.
   */
  def tpe(v:String) = jsOpt("type", v)
}

/*
@ScalaJSDefined
class JsTreeTheme extends js.Object
{
  /**
   * The location of all jstree themes - only used if url is set to true
   */
  var dir:UndefOr[String] = undefined
  
  /**
   * A boolean indicating if connecting dots are shown
   */
  var dots:UndefOr[Boolean] = undefined
  
  /**
   * A boolean indicating if node icons are shown
   */
  var icons:UndefOr[Boolean] = undefined
  
  /**
   * The name of the theme to use (if left as false the default theme is used)
   */
  var name:UndefOr[String] = undefined
  
  /**
   * A boolean specifying if a reponsive version of the theme should kick in on smaller screens (if the theme supports it). Defaults to false.
   */
  var responsive:UndefOr[Boolean] = undefined
  
  /**
   * A boolean indicating if the tree background is striped
   */
  var striped:UndefOr[Boolean] = undefined
  
  /**
   * The URL of the theme's CSS file, leave this as false if you have manually 
   * included the theme CSS (recommended). You can set this to true too which will try to autoload the theme.
   */
  var url:UndefOr[String | Boolean] = undefined
  
  /**
   * A string (or boolean false) specifying the theme variant to use (if the theme supports variants)
   */
  var variant:UndefOr[String | Boolean] = undefined
}
*/

@js.native
trait JsTreeTheme extends js.Object 
object JsTreeTheme extends JsTreeThemeBuilder(noOpts)
class JsTreeThemeBuilder(val dict:OptMap) extends JSOptionBuilder[JsTreeTheme, JsTreeThemeBuilder](new JsTreeThemeBuilder(_)) 
{
  /**
   * The location of all jstree themes - only used if url is set to true
   */
  def dir(v:String) = jsOpt("dir", v)
  
  /**
   * A boolean indicating if connecting dots are shown
   */
  def dots(v:Boolean) = jsOpt("dots", v)
  
  /**
   * A boolean indicating if node icons are shown
   */
  def icons(v:Boolean) = jsOpt("icons", v)
  
  /**
   * The name of the theme to use (if left as false the default theme is used)
   */
  def name(v:String) = jsOpt("name", v)
  
  /**
   * A boolean specifying if a reponsive version of the theme should kick in on smaller screens (if the theme supports it). Defaults to false.
   */
  def responsive(v:Boolean) = jsOpt("responsive", v)
  
  /**
   * A boolean indicating if the tree background is striped
   */
  def striped(v:Boolean) = jsOpt("striped", v)
  
  /**
   * The URL of the theme's CSS file, leave this as false if you have manually 
   * included the theme CSS (recommended). You can set this to true too which will try to autoload the theme.
   */
  def url(v:String | Boolean) = jsOpt("url", v)
  
  /**
   * A string (or boolean false) specifying the theme variant to use (if the theme supports variants)
   */
  def variant(v:String | Boolean) = jsOpt("variant", v)
}

/*
@ScalaJSDefined
class JsTreeCheckbox extends js.Object
{
  /**
   * This setting controls how cascading and undetermined nodes are applied.
   * 
   * If three_state is set to true this setting is automatically set to 'up+down+undetermined'. Defaults to ''.
   */
  var cascade:js.UndefOr[String] = js.undefined
  
  /**
   * A more strongly-typed way to set cascade.
   */
  def setCascade(v:NodeCascade*) = cascade = v.map(_.name).mkString("+")
  
  /**
   * A boolean indicating if checkboxes should cascade down and have an undetermined state. Defaults to true.
   */
  @JSName("keep_selected_style")
  var keepSelectedStyle:js.UndefOr[Boolean] = js.undefined
  
  /**
   * A boolean indicating if checkboxes should cascade down and have an undetermined state. Defaults to true.
   */
  @JSName("three_state")
  var threeState:js.UndefOr[Boolean] = js.undefined
    
  /**
   * This setting controls if checkbox are bound to the general tree selection or to an internal array maintained by the checkbox plugin. 
   * Defaults to true, only set to false if you know exactly what you are doing.
   */
  @JSName("tie_selection")
  var tieSelection:js.UndefOr[Boolean] = js.undefined
  
  /**
   * A boolean indicating if checkboxes should be visible (can be changed at a later time using show_checkboxes() and hide_checkboxes). Defaults to true.
   */
  var visible:js.UndefOr[Boolean] = js.undefined
  
  /**
   * A boolean indicating if clicking anywhere on the node should act as clicking on the checkbox. Defaults to true.
   */
  @JSName("whole_node")
  var wholeNode:js.UndefOr[Boolean] = js.undefined
}
*/

@js.native
trait JsTreeCheckbox extends js.Object 
object JsTreeCheckbox extends JsTreeCheckboxBuilder(noOpts)
class JsTreeCheckboxBuilder(val dict:OptMap) extends JSOptionBuilder[JsTreeCheckbox, JsTreeCheckboxBuilder](new JsTreeCheckboxBuilder(_))
{
  /**
   * This setting controls how cascading and undetermined nodes are applied.
   * 
   * If three_state is set to true this setting is automatically set to 'up+down+undetermined'. Defaults to ''.
   */
  def cascade(v:NodeCascade*) = jsOpt("cascade", v.map(_.name).mkString("+"))
  
  /**
   * A boolean indicating if the selected style of a node should be kept, or removed. Defaults to true.
   */
  def keepSelectedStyle(v:Boolean) = jsOpt("keep_selected_style", v)
  
  /**
   * A boolean indicating if checkboxes should cascade down and have an undetermined state. Defaults to true.
   */
  def threeState(v:Boolean) = jsOpt("three_state", v)
  
  /**
   * This setting controls if checkbox are bound to the general tree selection or to an internal array maintained by the checkbox plugin. 
   * Defaults to true, only set to false if you know exactly what you are doing.
   */
  def tieSelection(v:Boolean) = jsOpt("tie_selection", v)
  
  /**
   * A boolean indicating if checkboxes should be visible (can be changed at a later time using show_checkboxes() and hide_checkboxes). Defaults to true.
   */
  def visible(v:Boolean) = jsOpt("visible", v)
  
  /**
   * A boolean indicating if clicking anywhere on the node should act as clicking on the checkbox. Defaults to true.
   */
  def wholeNode(v:Boolean) = jsOpt("whole_node", v)
}

class NodeCascade(val name:String)
object NodeCascade {
  case object Up extends NodeCascade("up")
  case object Down extends NodeCascade("down")
  case object Undetermined extends NodeCascade("undetermined")
}

/*
@ScalaJSDefined
class NodeState(val name:String, val set:Boolean) extends js.Object
{
  /**
   * If the node should be initially opened
   */
  var opened:UndefOr[Boolean] = undefined
  /**
   * If the node should be disabled
   */
  var disabled:UndefOr[Boolean] = undefined
  /**
   * If the node should be initially selected
   */
  var selected:UndefOr[Boolean] = undefined
  /**
   * Checkbox plugin specific - if the node should be checked (only used when 
   * tie_to_selection is false, which you should only do if you really know what you are doing)
   */
  var checked:UndefOr[Boolean] = undefined
  /**
   * Checkbox plugin specific - if the node should be rendered in undetermined state (only used 
   * with lazy loading and when the node is not yet loaded, otherwise this state is automatically calculated).
   */
  var undetermined:UndefOr[Boolean] = undefined
}
*/

class NodeState(val name:String, val set:Boolean)
// Note that, for now, we're only bothering to define "turn on" versions of these. If there is
// demand, we could define the inverses.
object NodeState {
  /**
   * If the node should be initially selected
   */
  case object Selected extends NodeState("selected", true)
  /**
   * If the node should be initially opened
   */
  case object Opened extends NodeState("opened", true)
  /**
   * If the node should be disabled
   */
  case object Disabled extends NodeState("disabled", true)
  /**
   * Checkbox plugin specific - if the node should be checked (only used when 
   * tie_to_selection is false, which you should only do if you really know what you are doing)
   */
  case object Checked extends NodeState("checked", true)
  /**
   * Checkbox plugin specific - if the node should be rendered in undetermined state (only used 
   * with lazy loading and when the node is not yet loaded, otherwise this state is automatically calculated).
   */
  case object Undetermined extends NodeState("undetermined", true)
}

/**
 * A plugin that can be used in the plugins config.
 * 
 * Note that this is intentionally *not* sealed, so that you can add additional plugins.
 */
class JsTreePlugin(val name:String)
object JsTreePlugins {
  case object Changed extends JsTreePlugin("changed")
  case object Checkbox extends JsTreePlugin("checkbox")
  case object ConditionalSelect extends JsTreePlugin("conditionalselect")
  case object ContextMenu extends JsTreePlugin("contextmenu")
  case object DragAndDrop extends JsTreePlugin("dnd")
  case object MassLoad extends JsTreePlugin("massload")
  case object Search extends JsTreePlugin("search")
  case object Sort extends JsTreePlugin("sort")
  case object State extends JsTreePlugin("state")
  case object Types extends JsTreePlugin("types")
  case object Unique extends JsTreePlugin("unique")
  case object WholeRow extends JsTreePlugin("wholerow")
}
