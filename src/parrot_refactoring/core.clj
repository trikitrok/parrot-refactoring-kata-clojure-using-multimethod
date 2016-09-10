(ns parrot-refactoring.core)

(def ^:private load-factor 9.0)

(def ^:private base-speed 12.0)

(defn- compute-base-speed-for-voltage [voltage]
  (min 24.0 (* voltage base-speed)))

(defmulti speed* :type)

(defmethod speed* :european-parrot [_]
  base-speed)

(defn speed [parrot]
  (case (:type parrot)
    :european-parrot (speed* parrot)
    :african-parrot (max 0.0 (- base-speed (* load-factor (:num-coconuts parrot))))
    :norwegian-blue-parrot (if (:nailed parrot)
                             0.0
                             (compute-base-speed-for-voltage (:voltage parrot)))
    (throw "Should be unreachable!")))
