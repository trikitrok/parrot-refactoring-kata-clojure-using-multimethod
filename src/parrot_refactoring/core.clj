(ns parrot-refactoring.core)

(def ^:private load-factor 9.0)

(def ^:private base-speed 12.0)

(defn- compute-base-speed-for-voltage [voltage]
  (min 24.0 (* voltage base-speed)))

(defmulti speed :type)

(defmethod speed :european-parrot [_]
  base-speed)

(defmethod speed :african-parrot [{:keys [num-coconuts]}]
  (max 0.0 (- base-speed (* load-factor num-coconuts))))

(defmethod speed :norwegian-blue-parrot [{:keys [nailed voltage]}]
  (if nailed
    0.0
    (compute-base-speed-for-voltage voltage)))

(defmethod speed :default [_]
  (throw (Exception. "Should be unreachable!")))
