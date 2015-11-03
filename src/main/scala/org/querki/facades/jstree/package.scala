package org.querki.facades

import org.querki.jquery._

/**
 * @author jducoeur
 */
package object jstree {
  implicit def jq2JsTree(jq:JQuery):JsTree = jq.asInstanceOf[JsTree]
}
